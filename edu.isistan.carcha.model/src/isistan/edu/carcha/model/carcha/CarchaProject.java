/**
 */
package isistan.edu.carcha.model.carcha;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link isistan.edu.carcha.model.carcha.CarchaProject#getId <em>Id</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.CarchaProject#getName <em>Name</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.CarchaProject#getDescription <em>Description</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.CarchaProject#getLinks <em>Links</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.CarchaProject#getConcerns <em>Concerns</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.CarchaProject#getDesignDecisions <em>Design Decisions</em>}</li>
 * </ul>
 * </p>
 *
 * @see isistan.edu.carcha.model.carcha.CarchaPackage#getCarchaProject()
 * @model
 * @generated
 */
public interface CarchaProject extends EObject {
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
	 * @see isistan.edu.carcha.model.carcha.CarchaPackage#getCarchaProject_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link isistan.edu.carcha.model.carcha.CarchaProject#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see isistan.edu.carcha.model.carcha.CarchaPackage#getCarchaProject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link isistan.edu.carcha.model.carcha.CarchaProject#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see isistan.edu.carcha.model.carcha.CarchaPackage#getCarchaProject_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link isistan.edu.carcha.model.carcha.CarchaProject#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link isistan.edu.carcha.model.carcha.TraceabilityLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see isistan.edu.carcha.model.carcha.CarchaPackage#getCarchaProject_Links()
	 * @model containment="true"
	 * @generated
	 */
	EList<TraceabilityLink> getLinks();

	/**
	 * Returns the value of the '<em><b>Concerns</b></em>' containment reference list.
	 * The list contents are of type {@link isistan.edu.carcha.model.carcha.CrosscuttingConcern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concerns</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concerns</em>' containment reference list.
	 * @see isistan.edu.carcha.model.carcha.CarchaPackage#getCarchaProject_Concerns()
	 * @model containment="true"
	 * @generated
	 */
	EList<CrosscuttingConcern> getConcerns();

	/**
	 * Returns the value of the '<em><b>Design Decisions</b></em>' containment reference list.
	 * The list contents are of type {@link isistan.edu.carcha.model.carcha.DesignDecision}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Design Decisions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Design Decisions</em>' containment reference list.
	 * @see isistan.edu.carcha.model.carcha.CarchaPackage#getCarchaProject_DesignDecisions()
	 * @model containment="true"
	 * @generated
	 */
	EList<DesignDecision> getDesignDecisions();

} // CarchaProject
