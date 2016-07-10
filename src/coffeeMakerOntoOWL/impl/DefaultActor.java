package coffeeMakerOntoOWL.impl;


import coffeeMakerOntoOWL.*;

/**
* Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#Actor
* @author OntologyBeanGenerator v4.1
* @version 2014/06/20, 15:47:24
*/
public class DefaultActor implements Actor {

  private static final long serialVersionUID = -3583265682521255949L;

  private String _internalInstanceName = null;

  public DefaultActor() {
    this._internalInstanceName = "";
  }

  public DefaultActor(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: http://www.owl-ontologies.com/CoffeeMaker.owl#start
   */
   private Start start;
   public void setStart(Start value) { 
    this.start=value;
   }
   public Start getStart() {
     return this.start;
   }

}
