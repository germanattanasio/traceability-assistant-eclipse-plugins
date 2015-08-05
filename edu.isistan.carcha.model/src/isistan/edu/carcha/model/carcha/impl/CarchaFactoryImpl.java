/**
 */
package isistan.edu.carcha.model.carcha.impl;

import isistan.edu.carcha.model.carcha.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CarchaFactoryImpl extends EFactoryImpl implements CarchaFactory {
	
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the carcha factory
	 * @generated 
	 */
	public static CarchaFactory init() {
		try {
			CarchaFactory theCarchaFactory = (CarchaFactory)EPackage.Registry.INSTANCE.getEFactory(CarchaPackage.eNS_URI);
			if (theCarchaFactory != null) {
				return theCarchaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CarchaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CarchaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param eClass the e class
	 * @return the e object
	 * @generated 
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CarchaPackage.CARCHA_PROJECT: return createCarchaProject();
			case CarchaPackage.CROSSCUTTING_CONCERN: return createCrosscuttingConcern();
			case CarchaPackage.DESIGN_DECISION: return createDesignDecision();
			case CarchaPackage.TRACEABILITY_LINK: return createTraceabilityLink();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the carcha project
	 * @generated 
	 */
	public CarchaProject createCarchaProject() {
		CarchaProjectImpl carchaProject = new CarchaProjectImpl();
		return carchaProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the crosscutting concern
	 * @generated 
	 */
	public CrosscuttingConcern createCrosscuttingConcern() {
		CrosscuttingConcernImpl crosscuttingConcern = new CrosscuttingConcernImpl();
		return crosscuttingConcern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the design decision
	 * @generated 
	 */
	public DesignDecision createDesignDecision() {
		DesignDecisionImpl designDecision = new DesignDecisionImpl();
		return designDecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the traceability link
	 * @generated 
	 */
	public TraceabilityLink createTraceabilityLink() {
		TraceabilityLinkImpl traceabilityLink = new TraceabilityLinkImpl();
		return traceabilityLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the carcha package
	 * @generated 
	 */
	public CarchaPackage getCarchaPackage() {
		return (CarchaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the package
	 * @deprecated 
	 * @generated 
	 */
	@Deprecated
	public static CarchaPackage getPackage() {
		return CarchaPackage.eINSTANCE;
	}

} //CarchaFactoryImpl
