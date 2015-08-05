/**
 */
package isistan.edu.carcha.model.carcha.impl;

import isistan.edu.carcha.model.carcha.CarchaPackage;
import isistan.edu.carcha.model.carcha.CrosscuttingConcern;
import isistan.edu.carcha.model.carcha.DesignDecision;
import isistan.edu.carcha.model.carcha.TraceabilityLink;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traceability Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link isistan.edu.carcha.model.carcha.impl.TraceabilityLinkImpl#getId <em>Id</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.impl.TraceabilityLinkImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.impl.TraceabilityLinkImpl#getConcern <em>Concern</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.impl.TraceabilityLinkImpl#getDesignDecision <em>Design Decision</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceabilityLinkImpl extends MinimalEObjectImpl.Container implements TraceabilityLink {
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
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final double WEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected double weight = WEIGHT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConcern() <em>Concern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcern()
	 * @generated
	 * @ordered
	 */
	protected CrosscuttingConcern concern;

	/**
	 * The cached value of the '{@link #getDesignDecision() <em>Design Decision</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesignDecision()
	 * @generated
	 * @ordered
	 */
	protected DesignDecision designDecision;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @generated 
	 */
	protected TraceabilityLinkImpl() {
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
		return CarchaPackage.Literals.TRACEABILITY_LINK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CarchaPackage.TRACEABILITY_LINK__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the weight
	 * @generated 
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param newWeight the new weight
	 * @generated 
	 */
	public void setWeight(double newWeight) {
		double oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CarchaPackage.TRACEABILITY_LINK__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the concern
	 * @generated 
	 */
	public CrosscuttingConcern getConcern() {
		return concern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param newConcern the new concern
	 * @param msgs the msgs
	 * @return the notification chain
	 * @generated 
	 */
	public NotificationChain basicSetConcern(CrosscuttingConcern newConcern, NotificationChain msgs) {
		CrosscuttingConcern oldConcern = concern;
		concern = newConcern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CarchaPackage.TRACEABILITY_LINK__CONCERN, oldConcern, newConcern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param newConcern the new concern
	 * @generated 
	 */
	public void setConcern(CrosscuttingConcern newConcern) {
		if (newConcern != concern) {
			NotificationChain msgs = null;
			if (concern != null)
				msgs = ((InternalEObject)concern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CarchaPackage.TRACEABILITY_LINK__CONCERN, null, msgs);
			if (newConcern != null)
				msgs = ((InternalEObject)newConcern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CarchaPackage.TRACEABILITY_LINK__CONCERN, null, msgs);
			msgs = basicSetConcern(newConcern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CarchaPackage.TRACEABILITY_LINK__CONCERN, newConcern, newConcern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the design decision
	 * @generated 
	 */
	public DesignDecision getDesignDecision() {
		return designDecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param newDesignDecision the new design decision
	 * @param msgs the msgs
	 * @return the notification chain
	 * @generated 
	 */
	public NotificationChain basicSetDesignDecision(DesignDecision newDesignDecision, NotificationChain msgs) {
		DesignDecision oldDesignDecision = designDecision;
		designDecision = newDesignDecision;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CarchaPackage.TRACEABILITY_LINK__DESIGN_DECISION, oldDesignDecision, newDesignDecision);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param newDesignDecision the new design decision
	 * @generated 
	 */
	public void setDesignDecision(DesignDecision newDesignDecision) {
		if (newDesignDecision != designDecision) {
			NotificationChain msgs = null;
			if (designDecision != null)
				msgs = ((InternalEObject)designDecision).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CarchaPackage.TRACEABILITY_LINK__DESIGN_DECISION, null, msgs);
			if (newDesignDecision != null)
				msgs = ((InternalEObject)newDesignDecision).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CarchaPackage.TRACEABILITY_LINK__DESIGN_DECISION, null, msgs);
			msgs = basicSetDesignDecision(newDesignDecision, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CarchaPackage.TRACEABILITY_LINK__DESIGN_DECISION, newDesignDecision, newDesignDecision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param otherEnd the other end
	 * @param featureID the feature id
	 * @param msgs the msgs
	 * @return the notification chain
	 * @generated 
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CarchaPackage.TRACEABILITY_LINK__CONCERN:
				return basicSetConcern(null, msgs);
			case CarchaPackage.TRACEABILITY_LINK__DESIGN_DECISION:
				return basicSetDesignDecision(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case CarchaPackage.TRACEABILITY_LINK__ID:
				return getId();
			case CarchaPackage.TRACEABILITY_LINK__WEIGHT:
				return getWeight();
			case CarchaPackage.TRACEABILITY_LINK__CONCERN:
				return getConcern();
			case CarchaPackage.TRACEABILITY_LINK__DESIGN_DECISION:
				return getDesignDecision();
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
			case CarchaPackage.TRACEABILITY_LINK__ID:
				setId((String)newValue);
				return;
			case CarchaPackage.TRACEABILITY_LINK__WEIGHT:
				setWeight((Double)newValue);
				return;
			case CarchaPackage.TRACEABILITY_LINK__CONCERN:
				setConcern((CrosscuttingConcern)newValue);
				return;
			case CarchaPackage.TRACEABILITY_LINK__DESIGN_DECISION:
				setDesignDecision((DesignDecision)newValue);
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
			case CarchaPackage.TRACEABILITY_LINK__ID:
				setId(ID_EDEFAULT);
				return;
			case CarchaPackage.TRACEABILITY_LINK__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
				return;
			case CarchaPackage.TRACEABILITY_LINK__CONCERN:
				setConcern((CrosscuttingConcern)null);
				return;
			case CarchaPackage.TRACEABILITY_LINK__DESIGN_DECISION:
				setDesignDecision((DesignDecision)null);
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
			case CarchaPackage.TRACEABILITY_LINK__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CarchaPackage.TRACEABILITY_LINK__WEIGHT:
				return weight != WEIGHT_EDEFAULT;
			case CarchaPackage.TRACEABILITY_LINK__CONCERN:
				return concern != null;
			case CarchaPackage.TRACEABILITY_LINK__DESIGN_DECISION:
				return designDecision != null;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", weight: ");
		result.append(weight);
		result.append(')');
		return result.toString();
	}

} //TraceabilityLinkImpl
