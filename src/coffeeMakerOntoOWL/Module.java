package coffeeMakerOntoOWL;


import jade.util.leap.*;

/**
* Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#Module
* @author OntologyBeanGenerator v4.1
* @version 2014/06/20, 15:47:24
*/
public interface Module extends jade.content.Concept {

   /**
   * Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#hasSensor
   */
   public void addHasSensor(Sensor elem);
   public boolean removeHasSensor(Sensor elem);
   public void clearAllHasSensor();
   public Iterator getAllHasSensor();
   public List getHasSensor();
   public void setHasSensor(List l);

   /**
   * Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#hasActor
   */
   public void addHasActor(Actor elem);
   public boolean removeHasActor(Actor elem);
   public void clearAllHasActor();
   public Iterator getAllHasActor();
   public List getHasActor();
   public void setHasActor(List l);

}
