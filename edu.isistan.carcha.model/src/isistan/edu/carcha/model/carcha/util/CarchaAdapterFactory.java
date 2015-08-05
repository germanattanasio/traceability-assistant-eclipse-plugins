/**
 */
package isistan.edu.carcha.model.carcha.util;

import isistan.edu.carcha.model.carcha.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see isistan.edu.carcha.model.carcha.CarchaPackage
 * @generated
 */
public class CarchaAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CarchaPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CarchaAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CarchaPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 *
	 * @param object the object
	 * @return whether this factory is applicable for the type of the object.
	 * @generated 
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CarchaSwitch<Adapter> modelSwitch =
		new CarchaSwitch<Adapter>() {
			@Override
			public Adapter caseCarchaProject(CarchaProject object) {
				return createCarchaProjectAdapter();
			}
			@Override
			public Adapter caseCrosscuttingConcern(CrosscuttingConcern object) {
				return createCrosscuttingConcernAdapter();
			}
			@Override
			public Adapter caseDesignDecision(DesignDecision object) {
				return createDesignDecisionAdapter();
			}
			@Override
			public Adapter caseTraceabilityLink(TraceabilityLink object) {
				return createTraceabilityLinkAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link isistan.edu.carcha.model.carcha.CarchaProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see isistan.edu.carcha.model.carcha.CarchaProject
	 * @generated
	 */
	public Adapter createCarchaProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link isistan.edu.carcha.model.carcha.CrosscuttingConcern <em>Crosscutting Concern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see isistan.edu.carcha.model.carcha.CrosscuttingConcern
	 * @generated
	 */
	public Adapter createCrosscuttingConcernAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link isistan.edu.carcha.model.carcha.DesignDecision <em>Design Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see isistan.edu.carcha.model.carcha.DesignDecision
	 * @generated
	 */
	public Adapter createDesignDecisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link isistan.edu.carcha.model.carcha.TraceabilityLink <em>Traceability Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see isistan.edu.carcha.model.carcha.TraceabilityLink
	 * @generated
	 */
	public Adapter createTraceabilityLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CarchaAdapterFactory
