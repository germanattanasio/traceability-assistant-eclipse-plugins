/**
 */
package isistan.edu.carcha.model.carcha.impl;

import isistan.edu.carcha.model.carcha.CarchaPackage;
import isistan.edu.carcha.model.carcha.CarchaProject;
import isistan.edu.carcha.model.carcha.CrosscuttingConcern;
import isistan.edu.carcha.model.carcha.DesignDecision;
import isistan.edu.carcha.model.carcha.TraceabilityLink;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link isistan.edu.carcha.model.carcha.impl.CarchaProjectImpl#getId <em>Id</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.impl.CarchaProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.impl.CarchaProjectImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.impl.CarchaProjectImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.impl.CarchaProjectImpl#getConcerns <em>Concerns</em>}</li>
 *   <li>{@link isistan.edu.carcha.model.carcha.impl.CarchaProjectImpl#getDesignDecisions <em>Design Decisions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CarchaProjectImpl extends MinimalEObjectImpl.Container implements CarchaProject {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceabilityLink> links;

	/**
	 * The cached value of the '{@link #getConcerns() <em>Concerns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcerns()
	 * @generated
	 * @ordered
	 */
	protected EList<CrosscuttingConcern> concerns;

	/**
	 * The cached value of the '{@link #getDesignDecisions() <em>Design Decisions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesignDecisions()
	 * @generated
	 * @ordered
	 */
	protected EList<DesignDecision> designDecisions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @generated 
	 */
	protected CarchaProjectImpl() {
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
		return CarchaPackage.Literals.CARCHA_PROJECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CarchaPackage.CARCHA_PROJECT__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CarchaPackage.CARCHA_PROJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the description
	 * @generated 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param newDescription the new description
	 * @generated 
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CarchaPackage.CARCHA_PROJECT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the links
	 * @generated 
	 */
	public EList<TraceabilityLink> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList<TraceabilityLink>(TraceabilityLink.class, this, CarchaPackage.CARCHA_PROJECT__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the concerns
	 * @generated 
	 */
	public EList<CrosscuttingConcern> getConcerns() {
		if (concerns == null) {
			concerns = new EObjectContainmentEList<CrosscuttingConcern>(CrosscuttingConcern.class, this, CarchaPackage.CARCHA_PROJECT__CONCERNS);
		}
		return concerns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the design decisions
	 * @generated 
	 */
	public EList<DesignDecision> getDesignDecisions() {
		if (designDecisions == null) {
			designDecisions = new EObjectContainmentEList<DesignDecision>(DesignDecision.class, this, CarchaPackage.CARCHA_PROJECT__DESIGN_DECISIONS);
		}
		return designDecisions;
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
			case CarchaPackage.CARCHA_PROJECT__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
			case CarchaPackage.CARCHA_PROJECT__CONCERNS:
				return ((InternalEList<?>)getConcerns()).basicRemove(otherEnd, msgs);
			case CarchaPackage.CARCHA_PROJECT__DESIGN_DECISIONS:
				return ((InternalEList<?>)getDesignDecisions()).basicRemove(otherEnd, msgs);
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
			case CarchaPackage.CARCHA_PROJECT__ID:
				return getId();
			case CarchaPackage.CARCHA_PROJECT__NAME:
				return getName();
			case CarchaPackage.CARCHA_PROJECT__DESCRIPTION:
				return getDescription();
			case CarchaPackage.CARCHA_PROJECT__LINKS:
				return getLinks();
			case CarchaPackage.CARCHA_PROJECT__CONCERNS:
				return getConcerns();
			case CarchaPackage.CARCHA_PROJECT__DESIGN_DECISIONS:
				return getDesignDecisions();
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CarchaPackage.CARCHA_PROJECT__ID:
				setId((String)newValue);
				return;
			case CarchaPackage.CARCHA_PROJECT__NAME:
				setName((String)newValue);
				return;
			case CarchaPackage.CARCHA_PROJECT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CarchaPackage.CARCHA_PROJECT__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends TraceabilityLink>)newValue);
				return;
			case CarchaPackage.CARCHA_PROJECT__CONCERNS:
				getConcerns().clear();
				getConcerns().addAll((Collection<? extends CrosscuttingConcern>)newValue);
				return;
			case CarchaPackage.CARCHA_PROJECT__DESIGN_DECISIONS:
				getDesignDecisions().clear();
				getDesignDecisions().addAll((Collection<? extends DesignDecision>)newValue);
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
			case CarchaPackage.CARCHA_PROJECT__ID:
				setId(ID_EDEFAULT);
				return;
			case CarchaPackage.CARCHA_PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CarchaPackage.CARCHA_PROJECT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CarchaPackage.CARCHA_PROJECT__LINKS:
				getLinks().clear();
				return;
			case CarchaPackage.CARCHA_PROJECT__CONCERNS:
				getConcerns().clear();
				return;
			case CarchaPackage.CARCHA_PROJECT__DESIGN_DECISIONS:
				getDesignDecisions().clear();
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
			case CarchaPackage.CARCHA_PROJECT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case CarchaPackage.CARCHA_PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CarchaPackage.CARCHA_PROJECT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CarchaPackage.CARCHA_PROJECT__LINKS:
				return links != null && !links.isEmpty();
			case CarchaPackage.CARCHA_PROJECT__CONCERNS:
				return concerns != null && !concerns.isEmpty();
			case CarchaPackage.CARCHA_PROJECT__DESIGN_DECISIONS:
				return designDecisions != null && !designDecisions.isEmpty();
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
		result.append(", name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //CarchaProjectImpl
