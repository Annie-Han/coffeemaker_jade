package Agent;

import java.security.acl.Acl;

import Agent.LocalCommunicationAgent.StartBehaviour;
import coffeeMakerOntoOWL.ReadWaterTemp;
import coffeeMakerOntoOWL.impl.DefaultReadWaterTemp;
import jade.content.Predicate;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.OntologyException;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.imtp.leap.JICP.MaskableJICPPeer;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.SimpleAchieveREResponder;

public class SensorAgent extends Agent {
	
	public void setup() {
		// Register the codec for the SL0 language
		getContentManager().registerLanguage(new SLCodec(),
				FIPANames.ContentLanguage.FIPA_SL0);

		// Register the ontology used by this application
		getContentManager().registerOntology(coffeeMakerOntoOWL.CoffeeMakerOWLOntology.getInstance());
		
		addBehaviour(new HandleMeasureRequestBehaviour(this));

	}

	// This class sends the water temperature to LocalCommAgent when receiving
	// Query message.
	class HandleMeasureRequestBehaviour extends SimpleAchieveREResponder {

		public HandleMeasureRequestBehaviour(Agent myAgent) {
			super(
					myAgent,
					MessageTemplate
							.and(MessageTemplate
									.MatchOntology(coffeeMakerOntoOWL.CoffeeMakerOWLOntology.ONTOLOGY_NAME),
									MessageTemplate
											.MatchPerformative(ACLMessage.QUERY_REF)));
		}

		public ACLMessage prepareResponse(ACLMessage msg) {
			ACLMessage reply = msg.createReply();
			if (msg.getPerformative() != ACLMessage.QUERY_REF) {
				reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
				reply.setContent(getLocalName() + " : (" + msg.toString()
						+ ") is not understood");
			}
			try {
				Predicate pred = (Predicate) myAgent.getContentManager()
						.extractContent(msg);
				if (!(pred instanceof ReadWaterTemp)) {
					
					// If the predicate for which the temp is queried is not
					// READWATERTEMP
					// reply with NOT_UNDERSTOOD
					reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
					String content = "(" + msg.toString() + ")";
					reply.setContent(content);
					return (reply);
				}

				reply.setPerformative(ACLMessage.INFORM);
				ReadWaterTemp rwt=new DefaultReadWaterTemp();
				rwt.setWaterTemp(43);
				reply.setContent("water Temp");
				myAgent.getContentManager().fillContent(reply, rwt);
				
			} catch (Codec.CodecException fe) {
				System.err.println(myAgent.getLocalName()+" Fill/extract content unsucceeded. Reason:" + fe.getMessage());
			}
			catch (OntologyException oe){
				System.err.println(myAgent.getLocalName()+" getRoleName() unsucceeded. Reason:" + oe.getMessage());
			}
			
			return reply;
		}

	}
}
