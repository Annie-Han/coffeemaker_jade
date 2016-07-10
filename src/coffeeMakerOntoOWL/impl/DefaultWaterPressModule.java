package coffeeMakerOntoOWL.impl;


import jade.util.leap.*;
import coffeeMakerOntoOWL.*;

/**
* Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#WaterPressModule
* @author OntologyBeanGenerator v4.1
* @version 2014/06/20, 15:47:24
*/
public class DefaultWaterPressModule implements WaterPressModule {

  private static final long serialVersionUID = -3583265682521255949L;

  private String _internalInstanceName = null;

  public DefaultWaterPressModule() {
    this._internalInstanceName = "";
  }

  public DefaultWaterPressModule(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#hasSensor
   */
   private List hasSensor = new ArrayList();
   public void addHasSensor(Sensor elem) { 
     hasSensor.add(elem);
   }
   public boolean removeHasSensor(Sensor elem) {
     boolean result = hasSensor.remove(elem);
     return result;
   }
   public void clearAllHasSensor() {
     hasSensor.clear();
   }
   public Iterator getAllHasSensor() {return hasSensor.iterator(); }
   public List getHasSensor() {return hasSensor; }
   public void setHasSensor(List l) {hasSensor = l; }

   /**
   * Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#hasActor
   */
   private List hasActor = new ArrayList();
   public void addHasActor(Actor elem) { 
     hasActor.add(elem);
   }
   public boolean removeHasActor(Actor elem) {
     boolean result = hasActor.remove(elem);
     return result;
   }
   public void clearAllHasActor() {
     hasActor.clear();
   }
   public Iterator getAllHasActor() {return hasActor.iterator(); }
   public List getHasActor() {return hasActor; }
   public void setHasActor(List l) {hasActor = l; }

}
