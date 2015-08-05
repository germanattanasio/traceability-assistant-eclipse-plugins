/**
 */
package isistan.edu.carcha.model.carcha;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see isistan.edu.carcha.model.carcha.CarchaPackage
 * @generated
 */
public interface CarchaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CarchaFactory eINSTANCE = isistan.edu.carcha.model.carcha.impl.CarchaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project</em>'.
	 * @generated
	 */
	CarchaProject createCarchaProject();

	/**
	 * Returns a new object of class '<em>Crosscutting Concern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Crosscutting Concern</em>'.
	 * @generated
	 */
	CrosscuttingConcern createCrosscuttingConcern();

	/**
	 * Returns a new object of class '<em>Design Decision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Design Decision</em>'.
	 * @generated
	 */
	DesignDecision createDesignDecision();

	/**
	 * Returns a new object of class '<em>Traceability Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traceability Link</em>'.
	 * @generated
	 */
	TraceabilityLink createTraceabilityLink();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CarchaPackage getCarchaPackage();

} //CarchaFactory
