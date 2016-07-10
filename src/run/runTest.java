package run;

import jade.wrapper.*;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.Agent;


public class runTest {



		public static void main(String[] args) {
			try {
				Runtime rt = Runtime.instance();
				rt.setCloseVM(true);
				
				Profile pMain = new ProfileImpl(null,1234,null);
				
				System.out.println("Launching a platform");
				AgentContainer mc = rt.createMainContainer(pMain);
				ProfileImpl pContainer = new ProfileImpl(null,1234,null);
				
//				 AgentController rma = mc.createNewAgent("runTest", "jade.tools.rma.rma", new Object[0]);
//				 rma.start();
				
				AgentController sensor = mc.createNewAgent("sensor", "Agent.SensorAgent", null);
				sensor.start();
				
				AgentController local = mc.createNewAgent("requester", "Agent.LocalCommunicationAgent", null);
				local.start();	
				
				
				
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	

}
