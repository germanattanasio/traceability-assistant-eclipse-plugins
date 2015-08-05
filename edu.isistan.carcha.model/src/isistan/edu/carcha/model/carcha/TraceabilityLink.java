/**
 */
package isistan.edu.carcha.model.carcha;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traceability Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link isistan.edu.carcha.model.carcha.TraceabilityLink#getId <em>Id</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.TraceabilityLink#getWeight <em>Weight</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.TraceabilityLink#getConcern <em>Concern</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.TraceabilityLink#getDesignDecision <em>Design Decision</em>}</li>
 * </ul>
 * </p>
 *
 * @see isistan.edu.carcha.model.carcha.CarchaPackage#getTraceabilityLink()
 * @model
 * @generated
 */
public interface TraceabilityLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see isistan.edu.carcha.model.carcha.CarchaPackage#getTraceabilityLink_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link isistan.edu.carcha.model.carcha.TraceabilityLink#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(double)
	 * @see isistan.edu.carcha.model.carcha.CarchaPackage#getTraceabilityLink_Weight()
	 * @model
	 * @generated
	 */
	double getWeight();

	/**
	 * Sets the value of the '{@link isistan.edu.carcha.model.carcha.TraceabilityLink#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(double value);

	/**
	 * Returns the value of the '<em><b>Concern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concern</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concern</em>' containment reference.
	 * @see #setConcern(CrosscuttingConcern)
	 * @see isistan.edu.carcha.model.carcha.CarchaPackage#getTraceabilityLink_Concern()
	 * @model containment="true"
	 * @generated
	 */
	CrosscuttingConcern getConcern();

	/**
	 * Sets the value of the '{@link isistan.edu.carcha.model.carcha.TraceabilityLink#getConcern <em>Concern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concern</em>' containment reference.
	 * @see #getConcern()
	 * @generated
	 */
	void setConcern(CrosscuttingConcern value);

	/**
	 * Returns the value of the '<em><b>Design Decision</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Design Decision</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Design Decision</em>' containment reference.
	 * @see #setDesignDecision(DesignDecision)
	 * @see isistan.edu.carcha.model.carcha.CarchaPackage#getTraceabilityLink_DesignDecision()
	 * @model containment="true"
	 * @generated
	 */
	DesignDecision getDesignDecision();

	/**
	 * Sets the value of the '{@link isistan.edu.carcha.model.carcha.TraceabilityLink#getDesignDecision <em>Design Decision</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Design Decision</em>' containment reference.
	 * @see #getDesignDecision()
	 * @generated
	 */
	void setDesignDecision(DesignDecision value);

} // TraceabilityLink
