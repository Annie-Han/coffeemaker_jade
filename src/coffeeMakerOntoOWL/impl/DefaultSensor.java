package coffeeMakerOntoOWL.impl;


import coffeeMakerOntoOWL.*;

/**
* Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#Sensor
* @author OntologyBeanGenerator v4.1
* @version 2014/06/20, 15:47:24
*/
public class DefaultSensor implements Sensor {

  private static final long serialVersionUID = -3583265682521255949L;

  private String _internalInstanceName = null;

  public DefaultSensor() {
    this._internalInstanceName = "";
  }

  public DefaultSensor(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

}
