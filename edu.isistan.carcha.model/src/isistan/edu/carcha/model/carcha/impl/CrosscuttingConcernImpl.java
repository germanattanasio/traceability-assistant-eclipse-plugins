/**
 */
package isistan.edu.carcha.model.carcha.impl;

import isistan.edu.carcha.model.carcha.CarchaPackage;
import isistan.edu.carcha.model.carcha.CrosscuttingConcern;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Crosscutting Concern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link isistan.edu.carcha.model.carcha.impl.CrosscuttingConcernImpl#getName <em>Name</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.impl.CrosscuttingConcernImpl#getId <em>Id</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.impl.CrosscuttingConcernImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CrosscuttingConcernImpl extends MinimalEObjectImpl.Container implements CrosscuttingConcern {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected String kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @generated 
	 */
	protected CrosscuttingConcernImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the e class
	 * @generated 
	 */
	@Override
	protected EClass eStaticClass() {
		return CarchaPackage.Literals.CROSSCUTTING_CONCERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the name
	 * @generated 
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param newName the new name
	 * @generated 
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CarchaPackage.CROSSCUTTING_CONCERN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the id
	 * @generated 
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param newId the new id
	 * @generated 
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CarchaPackage.CROSSCUTTING_CONCERN__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the kind
	 * @generated 
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param newKind the new kind
	 * @generated 
	 */
	public void setKind(String newKind) {
		String oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CarchaPackage.CROSSCUTTING_CONCERN__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param featureID the feature id
	 * @param resolve the resolve
	 * @param coreType the core type
	 * @return the object
	 * @generated 
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CarchaPackage.CROSSCUTTING_CONCERN__NAME:
				return getName();
			case CarchaPackage.CROSSCUTTING_CONCERN__ID:
				return getId();
			case CarchaPackage.CROSSCUTTING_CONCERN__KIND:
				return getKind();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param featureID the feature id
	 * @param newValue the new value
	 * @generated 
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CarchaPackage.CROSSCUTTING_CONCERN__NAME:
				setName((String)newValue);
				return;
			case CarchaPackage.CROSSCUTTING_CONCERN__ID:
				setId((String)newValue);
				return;
			case CarchaPackage.CROSSCUTTING_CONCERN__KIND:
				setKind((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param featureID the feature id
	 * @generated 
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CarchaPackage.CROSSCUTTING_CONCERN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CarchaPackage.CROSSCUTTING_CONCERN__ID:
				setId(ID_EDEFAULT);
				return;
			case CarchaPackage.CROSSCUTTING_CONCERN__KIND:
				setKind(KIND_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param featureID the feature id
	 * @return true, if successful
	 * @generated 
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CarchaPackage.CROSSCUTTING_CONCERN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CarchaPackage.CROSSCUTTING_CONCERN__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CarchaPackage.CROSSCUTTING_CONCERN__KIND:
				return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the string
	 * @generated 
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //CrosscuttingConcernImpl
