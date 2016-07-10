package coffeeMakerOntoOWL;



/**
* Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#WaterTempSensor
* @author OntologyBeanGenerator v4.1
* @version 2014/06/20, 15:47:24
*/
public interface WaterTempSensor extends Sensor {

   /**
   * Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#waterTempState
   */
   public void setWaterTempState(int value);
   public int getWaterTempState();

   /**
   * Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#waterTemp
   */
   public void setWaterTemp(float value);
   public float getWaterTemp();

}
