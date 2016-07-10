package Agent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import coffeeMakerOntoOWL.CoffeeMakerOWLOntology;
import coffeeMakerOntoOWL.ReadWaterTemp;
import coffeeMakerOntoOWL.WaterTempSensor;
import coffeeMakerOntoOWL.impl.DefaultReadWaterTemp;
import coffeeMakerOntoOWL.impl.DefaultWaterTempSensor;
import jade.content.abs.AbsObject;
import jade.content.abs.AbsPredicate;
import jade.content.lang.Codec.CodecException;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.proto.SimpleAchieveREInitiator;

public class LocalCommunicationAgent extends Agent {

	AID actor;
	AID sensor;

	class StartBehaviour extends SequentialBehaviour {
		Behaviour querySensorBehaviour = null;
		Behaviour requestActorBehaviour = null;

		public StartBehaviour(Agent myAgent) {
			super(myAgent);
		}

		public void onStart() {

			ReadWaterTemp readWaterTemp = new DefaultReadWaterTemp();
			readWaterTemp.setWaterTemp(20);
//			Ontology o = myAgent.getContentManager().lookupOntology(
//					CoffeeMakerOWLOntology.ONTOLOGY_NAME);

			ACLMessage querySensorMsg = new ACLMessage(ACLMessage.QUERY_REF);
			querySensorMsg
					.addReceiver(((LocalCommunicationAgent) myAgent).sensor);
			querySensorMsg.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
			querySensorMsg.setOntology(CoffeeMakerOWLOntology.ONTOLOGY_NAME);
			try {
				myAgent.getContentManager().fillContent(querySensorMsg,
						readWaterTemp);
				System.out.println(getLocalName() + " : query the waterTemp");

			} catch (Exception e) {
				e.printStackTrace();
			}

			querySensorBehaviour = new HandleOrderSensorBehaviour(myAgent,
					querySensorMsg);
			addSubBehaviour(querySensorBehaviour);

		}

		public int onEnd() {
			try {
				BufferedReader buff = new BufferedReader(new InputStreamReader(
						System.in));
				System.out.println("Would you like to continue?[y/n] ");
				String stop = buff.readLine();
				if (stop.equalsIgnoreCase("y")) {
					reset(); // This makes this behaviour be cyclically executed
					myAgent.addBehaviour(this);
				} else
					myAgent.doDelete(); // Exit
			} catch (IOException ioe) {
				System.err.println("I/O error: " + ioe.getMessage());
			}
			return 0;
		}

		public void reset() {
			if (querySensorBehaviour != null) {
				removeSubBehaviour(querySensorBehaviour);
				querySensorBehaviour = null;
			}
			if (requestActorBehaviour != null) {
				removeSubBehaviour(requestActorBehaviour);
				requestActorBehaviour = null;
			}
			super.reset();
		}

	}

	class HandleOrderSensorBehaviour extends SimpleAchieveREInitiator {

		public HandleOrderSensorBehaviour(Agent myAgent,
				ACLMessage querySensorMessage) {
			super(myAgent, querySensorMessage);
			querySensorMessage
					.setOntology(CoffeeMakerOWLOntology.ONTOLOGY_NAME);
		}

		protected void handleInform(ACLMessage msg) {
			try {
				AbsPredicate cs;

				cs = (AbsPredicate) myAgent.getContentManager()
						.extractAbsContent(msg);
				Ontology o = myAgent.getContentManager().lookupOntology(
						CoffeeMakerOWLOntology.ONTOLOGY_NAME);

				if (cs.getTypeName().equals(
						CoffeeMakerOWLOntology.READWATERTEMP)) {
					ReadWaterTemp rwt = (ReadWaterTemp) o
							.toObject((AbsObject) cs);
					float p = rwt.getWaterTemp();
					System.out.println(getLocalName() + ": Temp " + p);
				}
			} catch (CodecException | OntologyException e) {
				e.printStackTrace();
			}

		}

	}

	public void setup() {
		// Register the codec for the SL0 language
		getContentManager().registerLanguage(new SLCodec(),
				FIPANames.ContentLanguage.FIPA_SL0);

		// Register the ontology used by this application
		getContentManager().registerOntology(
				coffeeMakerOntoOWL.CoffeeMakerOWLOntology.getInstance());

		addBehaviour(new StartBehaviour(this));

	}
}
