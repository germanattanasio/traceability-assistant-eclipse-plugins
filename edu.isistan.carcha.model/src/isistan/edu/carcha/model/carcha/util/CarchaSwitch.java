/**
 */
package isistan.edu.carcha.model.carcha.util;

import isistan.edu.carcha.model.carcha.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @param <T> the generic type
 * @see isistan.edu.carcha.model.carcha.CarchaPackage
 * @generated 
 */
public class CarchaSwitch<T> extends Switch<T> {
	
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @generated 
	 */
	protected static CarchaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CarchaSwitch() {
		if (modelPackage == null) {
			modelPackage = CarchaPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param ePackage the e package
	 * @return whether this is a switch for the given package.
	 * @parameter ePackage the package in question.
	 * @generated 
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param classifierID the classifier id
	 * @param theEObject the the e object
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated 
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CarchaPackage.CARCHA_PROJECT: {
				CarchaProject carchaProject = (CarchaProject)theEObject;
				T result = caseCarchaProject(carchaProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CarchaPackage.CROSSCUTTING_CONCERN: {
				CrosscuttingConcern crosscuttingConcern = (CrosscuttingConcern)theEObject;
				T result = caseCrosscuttingConcern(crosscuttingConcern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CarchaPackage.DESIGN_DECISION: {
				DesignDecision designDecision = (DesignDecision)theEObject;
				T result = caseDesignDecision(designDecision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CarchaPackage.TRACEABILITY_LINK: {
				TraceabilityLink traceabilityLink = (TraceabilityLink)theEObject;
				T result = caseTraceabilityLink(traceabilityLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCarchaProject(CarchaProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Crosscutting Concern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Crosscutting Concern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCrosscuttingConcern(CrosscuttingConcern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Design Decision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Design Decision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDesignDecision(DesignDecision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traceability Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traceability Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceabilityLink(TraceabilityLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //CarchaSwitch
