/**
 */
package isistan.edu.carcha.model.carcha.impl;

import isistan.edu.carcha.model.carcha.CarchaFactory;
import isistan.edu.carcha.model.carcha.CarchaPackage;
import isistan.edu.carcha.model.carcha.CarchaProject;
import isistan.edu.carcha.model.carcha.CrosscuttingConcern;
import isistan.edu.carcha.model.carcha.DesignDecision;
import isistan.edu.carcha.model.carcha.TraceabilityLink;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CarchaPackageImpl extends EPackageImpl implements CarchaPackage {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @generated 
	 */
	private EClass carchaProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @generated 
	 */
	private EClass crosscuttingConcernEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @generated 
	 */
	private EClass designDecisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @generated 
	 */
	private EClass traceabilityLinkEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see isistan.edu.carcha.model.carcha.CarchaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CarchaPackageImpl() {
		super(eNS_URI, CarchaFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @generated 
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CarchaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the carcha package
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated 
	 */
	public static CarchaPackage init() {
		if (isInited) return (CarchaPackage)EPackage.Registry.INSTANCE.getEPackage(CarchaPackage.eNS_URI);

		// Obtain or create and register package
		CarchaPackageImpl theCarchaPackage = (CarchaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CarchaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CarchaPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCarchaPackage.createPackageContents();

		// Initialize created meta-data
		theCarchaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCarchaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CarchaPackage.eNS_URI, theCarchaPackage);
		return theCarchaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the carcha project
	 * @generated 
	 */
	public EClass getCarchaProject() {
		return carchaProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the carcha project_ id
	 * @generated 
	 */
	public EAttribute getCarchaProject_Id() {
		return (EAttribute)carchaProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the carcha project_ name
	 * @generated 
	 */
	public EAttribute getCarchaProject_Name() {
		return (EAttribute)carchaProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the carcha project_ description
	 * @generated 
	 */
	public EAttribute getCarchaProject_Description() {
		return (EAttribute)carchaProjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the carcha project_ links
	 * @generated 
	 */
	public EReference getCarchaProject_Links() {
		return (EReference)carchaProjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the carcha project_ concerns
	 * @generated 
	 */
	public EReference getCarchaProject_Concerns() {
		return (EReference)carchaProjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the carcha project_ design decisions
	 * @generated 
	 */
	public EReference getCarchaProject_DesignDecisions() {
		return (EReference)carchaProjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the crosscutting concern
	 * @generated 
	 */
	public EClass getCrosscuttingConcern() {
		return crosscuttingConcernEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the crosscutting concern_ name
	 * @generated 
	 */
	public EAttribute getCrosscuttingConcern_Name() {
		return (EAttribute)crosscuttingConcernEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the crosscutting concern_ id
	 * @generated 
	 */
	public EAttribute getCrosscuttingConcern_Id() {
		return (EAttribute)crosscuttingConcernEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the crosscutting concern_ kind
	 * @generated 
	 */
	public EAttribute getCrosscuttingConcern_Kind() {
		return (EAttribute)crosscuttingConcernEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the design decision
	 * @generated 
	 */
	public EClass getDesignDecision() {
		return designDecisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the design decision_ id
	 * @generated 
	 */
	public EAttribute getDesignDecision_Id() {
		return (EAttribute)designDecisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the design decision_ name
	 * @generated 
	 */
	public EAttribute getDesignDecision_Name() {
		return (EAttribute)designDecisionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the design decision_ kind
	 * @generated 
	 */
	public EAttribute getDesignDecision_Kind() {
		return (EAttribute)designDecisionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the traceability link
	 * @generated 
	 */
	public EClass getTraceabilityLink() {
		return traceabilityLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the traceability link_ id
	 * @generated 
	 */
	public EAttribute getTraceabilityLink_Id() {
		return (EAttribute)traceabilityLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the traceability link_ weight
	 * @generated 
	 */
	public EAttribute getTraceabilityLink_Weight() {
		return (EAttribute)traceabilityLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the traceability link_ concern
	 * @generated 
	 */
	public EReference getTraceabilityLink_Concern() {
		return (EReference)traceabilityLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the traceability link_ design decision
	 * @generated 
	 */
	public EReference getTraceabilityLink_DesignDecision() {
		return (EReference)traceabilityLinkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the carcha factory
	 * @generated 
	 */
	public CarchaFactory getCarchaFactory() {
		return (CarchaFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @generated 
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		carchaProjectEClass = createEClass(CARCHA_PROJECT);
		createEAttribute(carchaProjectEClass, CARCHA_PROJECT__ID);
		createEAttribute(carchaProjectEClass, CARCHA_PROJECT__NAME);
		createEAttribute(carchaProjectEClass, CARCHA_PROJECT__DESCRIPTION);
		createEReference(carchaProjectEClass, CARCHA_PROJECT__LINKS);
		createEReference(carchaProjectEClass, CARCHA_PROJECT__CONCERNS);
		createEReference(carchaProjectEClass, CARCHA_PROJECT__DESIGN_DECISIONS);

		crosscuttingConcernEClass = createEClass(CROSSCUTTING_CONCERN);
		createEAttribute(crosscuttingConcernEClass, CROSSCUTTING_CONCERN__NAME);
		createEAttribute(crosscuttingConcernEClass, CROSSCUTTING_CONCERN__ID);
		createEAttribute(crosscuttingConcernEClass, CROSSCUTTING_CONCERN__KIND);

		designDecisionEClass = createEClass(DESIGN_DECISION);
		createEAttribute(designDecisionEClass, DESIGN_DECISION__ID);
		createEAttribute(designDecisionEClass, DESIGN_DECISION__NAME);
		createEAttribute(designDecisionEClass, DESIGN_DECISION__KIND);

		traceabilityLinkEClass = createEClass(TRACEABILITY_LINK);
		createEAttribute(traceabilityLinkEClass, TRACEABILITY_LINK__ID);
		createEAttribute(traceabilityLinkEClass, TRACEABILITY_LINK__WEIGHT);
		createEReference(traceabilityLinkEClass, TRACEABILITY_LINK__CONCERN);
		createEReference(traceabilityLinkEClass, TRACEABILITY_LINK__DESIGN_DECISION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @generated 
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(carchaProjectEClass, CarchaProject.class, "CarchaProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCarchaProject_Id(), ecorePackage.getEString(), "id", null, 0, 1, CarchaProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCarchaProject_Name(), ecorePackage.getEString(), "name", null, 0, 1, CarchaProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCarchaProject_Description(), ecorePackage.getEString(), "description", null, 0, 1, CarchaProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCarchaProject_Links(), this.getTraceabilityLink(), null, "links", null, 0, -1, CarchaProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCarchaProject_Concerns(), this.getCrosscuttingConcern(), null, "concerns", null, 0, -1, CarchaProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCarchaProject_DesignDecisions(), this.getDesignDecision(), null, "designDecisions", null, 0, -1, CarchaProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(crosscuttingConcernEClass, CrosscuttingConcern.class, "CrosscuttingConcern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCrosscuttingConcern_Name(), ecorePackage.getEString(), "name", null, 0, 1, CrosscuttingConcern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCrosscuttingConcern_Id(), ecorePackage.getEString(), "id", null, 0, 1, CrosscuttingConcern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCrosscuttingConcern_Kind(), ecorePackage.getEString(), "kind", null, 0, 1, CrosscuttingConcern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(designDecisionEClass, DesignDecision.class, "DesignDecision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDesignDecision_Id(), ecorePackage.getEString(), "id", null, 0, 1, DesignDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDesignDecision_Name(), ecorePackage.getEString(), "name", null, 0, 1, DesignDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDesignDecision_Kind(), ecorePackage.getEString(), "kind", null, 0, 1, DesignDecision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceabilityLinkEClass, TraceabilityLink.class, "TraceabilityLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTraceabilityLink_Id(), ecorePackage.getEString(), "id", null, 0, 1, TraceabilityLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceabilityLink_Weight(), ecorePackage.getEDouble(), "weight", null, 0, 1, TraceabilityLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceabilityLink_Concern(), this.getCrosscuttingConcern(), null, "concern", null, 0, 1, TraceabilityLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceabilityLink_DesignDecision(), this.getDesignDecision(), null, "designDecision", null, 0, 1, TraceabilityLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CarchaPackageImpl
