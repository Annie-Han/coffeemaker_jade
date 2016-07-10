package coffeeMakerOntoOWL.impl;


import coffeeMakerOntoOWL.*;

/**
* Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#WaterTempSensor
* @author OntologyBeanGenerator v4.1
* @version 2014/06/20, 15:47:24
*/
public class DefaultWaterTempSensor implements WaterTempSensor {

  private static final long serialVersionUID = -3583265682521255949L;

  private String _internalInstanceName = null;

  public DefaultWaterTempSensor() {
    this._internalInstanceName = "";
  }

  public DefaultWaterTempSensor(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#waterTempState
   */
   private int waterTempState;
   public void setWaterTempState(int value) { 
    this.waterTempState=value;
   }
   public int getWaterTempState() {
     return this.waterTempState;
   }

   /**
   * Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#waterTemp
   */
   private float waterTemp;
   public void setWaterTemp(float value) { 
    this.waterTemp=value;
   }
   public float getWaterTemp() {
     return this.waterTemp;
   }

}
