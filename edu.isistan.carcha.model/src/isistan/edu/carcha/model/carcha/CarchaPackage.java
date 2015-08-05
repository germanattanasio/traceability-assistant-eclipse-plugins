/**
 */
package isistan.edu.carcha.model.carcha;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see isistan.edu.carcha.model.carcha.CarchaFactory
 * @model kind="package"
 * @generated
 */
public interface CarchaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "carcha";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://carcha/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "carcha";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CarchaPackage eINSTANCE = isistan.edu.carcha.model.carcha.impl.CarchaPackageImpl.init();

	/**
	 * The meta object id for the '{@link isistan.edu.carcha.model.carcha.impl.CarchaProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see isistan.edu.carcha.model.carcha.impl.CarchaProjectImpl
	 * @see isistan.edu.carcha.model.carcha.impl.CarchaPackageImpl#getCarchaProject()
	 * @generated
	 */
	int CARCHA_PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARCHA_PROJECT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARCHA_PROJECT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARCHA_PROJECT__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARCHA_PROJECT__LINKS = 3;

	/**
	 * The feature id for the '<em><b>Concerns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARCHA_PROJECT__CONCERNS = 4;

	/**
	 * The feature id for the '<em><b>Design Decisions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARCHA_PROJECT__DESIGN_DECISIONS = 5;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARCHA_PROJECT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARCHA_PROJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link isistan.edu.carcha.model.carcha.impl.CrosscuttingConcernImpl <em>Crosscutting Concern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see isistan.edu.carcha.model.carcha.impl.CrosscuttingConcernImpl
	 * @see isistan.edu.carcha.model.carcha.impl.CarchaPackageImpl#getCrosscuttingConcern()
	 * @generated
	 */
	int CROSSCUTTING_CONCERN = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__ID = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__KIND = 2;

	/**
	 * The number of structural features of the '<em>Crosscutting Concern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Crosscutting Concern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link isistan.edu.carcha.model.carcha.impl.DesignDecisionImpl <em>Design Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see isistan.edu.carcha.model.carcha.impl.DesignDecisionImpl
	 * @see isistan.edu.carcha.model.carcha.impl.CarchaPackageImpl#getDesignDecision()
	 * @generated
	 */
	int DESIGN_DECISION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGN_DECISION__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGN_DECISION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGN_DECISION__KIND = 2;

	/**
	 * The number of structural features of the '<em>Design Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGN_DECISION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Design Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESIGN_DECISION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link isistan.edu.carcha.model.carcha.impl.TraceabilityLinkImpl <em>Traceability Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see isistan.edu.carcha.model.carcha.impl.TraceabilityLinkImpl
	 * @see isistan.edu.carcha.model.carcha.impl.CarchaPackageImpl#getTraceabilityLink()
	 * @generated
	 */
	int TRACEABILITY_LINK = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_LINK__ID = 0;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_LINK__WEIGHT = 1;

	/**
	 * The feature id for the '<em><b>Concern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_LINK__CONCERN = 2;

	/**
	 * The feature id for the '<em><b>Design Decision</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_LINK__DESIGN_DECISION = 3;

	/**
	 * The number of structural features of the '<em>Traceability Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_LINK_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Traceability Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEABILITY_LINK_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link isistan.edu.carcha.model.carcha.CarchaProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see isistan.edu.carcha.model.carcha.CarchaProject
	 * @generated
	 */
	EClass getCarchaProject();

	/**
	 * Returns the meta object for the attribute '{@link isistan.edu.carcha.model.carcha.CarchaProject#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see isistan.edu.carcha.model.carcha.CarchaProject#getId()
	 * @see #getCarchaProject()
	 * @generated
	 */
	EAttribute getCarchaProject_Id();

	/**
	 * Returns the meta object for the attribute '{@link isistan.edu.carcha.model.carcha.CarchaProject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see isistan.edu.carcha.model.carcha.CarchaProject#getName()
	 * @see #getCarchaProject()
	 * @generated
	 */
	EAttribute getCarchaProject_Name();

	/**
	 * Returns the meta object for the attribute '{@link isistan.edu.carcha.model.carcha.CarchaProject#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see isistan.edu.carcha.model.carcha.CarchaProject#getDescription()
	 * @see #getCarchaProject()
	 * @generated
	 */
	EAttribute getCarchaProject_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link isistan.edu.carcha.model.carcha.CarchaProject#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see isistan.edu.carcha.model.carcha.CarchaProject#getLinks()
	 * @see #getCarchaProject()
	 * @generated
	 */
	EReference getCarchaProject_Links();

	/**
	 * Returns the meta object for the containment reference list '{@link isistan.edu.carcha.model.carcha.CarchaProject#getConcerns <em>Concerns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Concerns</em>'.
	 * @see isistan.edu.carcha.model.carcha.CarchaProject#getConcerns()
	 * @see #getCarchaProject()
	 * @generated
	 */
	EReference getCarchaProject_Concerns();

	/**
	 * Returns the meta object for the containment reference list '{@link isistan.edu.carcha.model.carcha.CarchaProject#getDesignDecisions <em>Design Decisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Design Decisions</em>'.
	 * @see isistan.edu.carcha.model.carcha.CarchaProject#getDesignDecisions()
	 * @see #getCarchaProject()
	 * @generated
	 */
	EReference getCarchaProject_DesignDecisions();

	/**
	 * Returns the meta object for class '{@link isistan.edu.carcha.model.carcha.CrosscuttingConcern <em>Crosscutting Concern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Crosscutting Concern</em>'.
	 * @see isistan.edu.carcha.model.carcha.CrosscuttingConcern
	 * @generated
	 */
	EClass getCrosscuttingConcern();

	/**
	 * Returns the meta object for the attribute '{@link isistan.edu.carcha.model.carcha.CrosscuttingConcern#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see isistan.edu.carcha.model.carcha.CrosscuttingConcern#getName()
	 * @see #getCrosscuttingConcern()
	 * @generated
	 */
	EAttribute getCrosscuttingConcern_Name();

	/**
	 * Returns the meta object for the attribute '{@link isistan.edu.carcha.model.carcha.CrosscuttingConcern#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see isistan.edu.carcha.model.carcha.CrosscuttingConcern#getId()
	 * @see #getCrosscuttingConcern()
	 * @generated
	 */
	EAttribute getCrosscuttingConcern_Id();

	/**
	 * Returns the meta object for the attribute '{@link isistan.edu.carcha.model.carcha.CrosscuttingConcern#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see isistan.edu.carcha.model.carcha.CrosscuttingConcern#getKind()
	 * @see #getCrosscuttingConcern()
	 * @generated
	 */
	EAttribute getCrosscuttingConcern_Kind();

	/**
	 * Returns the meta object for class '{@link isistan.edu.carcha.model.carcha.DesignDecision <em>Design Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Design Decision</em>'.
	 * @see isistan.edu.carcha.model.carcha.DesignDecision
	 * @generated
	 */
	EClass getDesignDecision();

	/**
	 * Returns the meta object for the attribute '{@link isistan.edu.carcha.model.carcha.DesignDecision#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see isistan.edu.carcha.model.carcha.DesignDecision#getId()
	 * @see #getDesignDecision()
	 * @generated
	 */
	EAttribute getDesignDecision_Id();

	/**
	 * Returns the meta object for the attribute '{@link isistan.edu.carcha.model.carcha.DesignDecision#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see isistan.edu.carcha.model.carcha.DesignDecision#getName()
	 * @see #getDesignDecision()
	 * @generated
	 */
	EAttribute getDesignDecision_Name();

	/**
	 * Returns the meta object for the attribute '{@link isistan.edu.carcha.model.carcha.DesignDecision#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see isistan.edu.carcha.model.carcha.DesignDecision#getKind()
	 * @see #getDesignDecision()
	 * @generated
	 */
	EAttribute getDesignDecision_Kind();

	/**
	 * Returns the meta object for class '{@link isistan.edu.carcha.model.carcha.TraceabilityLink <em>Traceability Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traceability Link</em>'.
	 * @see isistan.edu.carcha.model.carcha.TraceabilityLink
	 * @generated
	 */
	EClass getTraceabilityLink();

	/**
	 * Returns the meta object for the attribute '{@link isistan.edu.carcha.model.carcha.TraceabilityLink#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see isistan.edu.carcha.model.carcha.TraceabilityLink#getId()
	 * @see #getTraceabilityLink()
	 * @generated
	 */
	EAttribute getTraceabilityLink_Id();

	/**
	 * Returns the meta object for the attribute '{@link isistan.edu.carcha.model.carcha.TraceabilityLink#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see isistan.edu.carcha.model.carcha.TraceabilityLink#getWeight()
	 * @see #getTraceabilityLink()
	 * @generated
	 */
	EAttribute getTraceabilityLink_Weight();

	/**
	 * Returns the meta object for the containment reference '{@link isistan.edu.carcha.model.carcha.TraceabilityLink#getConcern <em>Concern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Concern</em>'.
	 * @see isistan.edu.carcha.model.carcha.TraceabilityLink#getConcern()
	 * @see #getTraceabilityLink()
	 * @generated
	 */
	EReference getTraceabilityLink_Concern();

	/**
	 * Returns the meta object for the containment reference '{@link isistan.edu.carcha.model.carcha.TraceabilityLink#getDesignDecision <em>Design Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Design Decision</em>'.
	 * @see isistan.edu.carcha.model.carcha.TraceabilityLink#getDesignDecision()
	 * @see #getTraceabilityLink()
	 * @generated
	 */
	EReference getTraceabilityLink_DesignDecision();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CarchaFactory getCarchaFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->.
	 *
	 * @generated 
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link isistan.edu.carcha.model.carcha.impl.CarchaProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see isistan.edu.carcha.model.carcha.impl.CarchaProjectImpl
		 * @see isistan.edu.carcha.model.carcha.impl.CarchaPackageImpl#getCarchaProject()
		 * @generated
		 */
		EClass CARCHA_PROJECT = eINSTANCE.getCarchaProject();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARCHA_PROJECT__ID = eINSTANCE.getCarchaProject_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARCHA_PROJECT__NAME = eINSTANCE.getCarchaProject_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CARCHA_PROJECT__DESCRIPTION = eINSTANCE.getCarchaProject_Description();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARCHA_PROJECT__LINKS = eINSTANCE.getCarchaProject_Links();

		/**
		 * The meta object literal for the '<em><b>Concerns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARCHA_PROJECT__CONCERNS = eINSTANCE.getCarchaProject_Concerns();

		/**
		 * The meta object literal for the '<em><b>Design Decisions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARCHA_PROJECT__DESIGN_DECISIONS = eINSTANCE.getCarchaProject_DesignDecisions();

		/**
		 * The meta object literal for the '{@link isistan.edu.carcha.model.carcha.impl.CrosscuttingConcernImpl <em>Crosscutting Concern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see isistan.edu.carcha.model.carcha.impl.CrosscuttingConcernImpl
		 * @see isistan.edu.carcha.model.carcha.impl.CarchaPackageImpl#getCrosscuttingConcern()
		 * @generated
		 */
		EClass CROSSCUTTING_CONCERN = eINSTANCE.getCrosscuttingConcern();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSSCUTTING_CONCERN__NAME = eINSTANCE.getCrosscuttingConcern_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSSCUTTING_CONCERN__ID = eINSTANCE.getCrosscuttingConcern_Id();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSSCUTTING_CONCERN__KIND = eINSTANCE.getCrosscuttingConcern_Kind();

		/**
		 * The meta object literal for the '{@link isistan.edu.carcha.model.carcha.impl.DesignDecisionImpl <em>Design Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see isistan.edu.carcha.model.carcha.impl.DesignDecisionImpl
		 * @see isistan.edu.carcha.model.carcha.impl.CarchaPackageImpl#getDesignDecision()
		 * @generated
		 */
		EClass DESIGN_DECISION = eINSTANCE.getDesignDecision();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESIGN_DECISION__ID = eINSTANCE.getDesignDecision_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESIGN_DECISION__NAME = eINSTANCE.getDesignDecision_Name();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESIGN_DECISION__KIND = eINSTANCE.getDesignDecision_Kind();

		/**
		 * The meta object literal for the '{@link isistan.edu.carcha.model.carcha.impl.TraceabilityLinkImpl <em>Traceability Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see isistan.edu.carcha.model.carcha.impl.TraceabilityLinkImpl
		 * @see isistan.edu.carcha.model.carcha.impl.CarchaPackageImpl#getTraceabilityLink()
		 * @generated
		 */
		EClass TRACEABILITY_LINK = eINSTANCE.getTraceabilityLink();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACEABILITY_LINK__ID = eINSTANCE.getTraceabilityLink_Id();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACEABILITY_LINK__WEIGHT = eINSTANCE.getTraceabilityLink_Weight();

		/**
		 * The meta object literal for the '<em><b>Concern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACEABILITY_LINK__CONCERN = eINSTANCE.getTraceabilityLink_Concern();

		/**
		 * The meta object literal for the '<em><b>Design Decision</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACEABILITY_LINK__DESIGN_DECISION = eINSTANCE.getTraceabilityLink_DesignDecision();

	}

} //CarchaPackage
