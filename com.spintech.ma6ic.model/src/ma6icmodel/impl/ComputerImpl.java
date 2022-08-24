/**
 */
package ma6icmodel.impl;

import java.util.Collection;
import ma6icmodel.Adapter;
import ma6icmodel.Computer;
import ma6icmodel.Ma6icmodelPackage;
import ma6icmodel.Telemetry;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ma6icmodel.impl.ComputerImpl#getAdapters <em>Adapters</em>}</li>
 *   <li>{@link ma6icmodel.impl.ComputerImpl#getName <em>Name</em>}</li>
 *   <li>{@link ma6icmodel.impl.ComputerImpl#getTelemetry <em>Telemetry</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputerImpl extends MinimalEObjectImpl.Container implements Computer {
	/**
	 * The cached value of the '{@link #getAdapters() <em>Adapters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapters()
	 * @generated
	 * @ordered
	 */
	protected EList<Adapter> adapters;

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
	 * The cached value of the '{@link #getTelemetry() <em>Telemetry</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelemetry()
	 * @generated
	 * @ordered
	 */
	protected EList<Telemetry> telemetry;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ma6icmodelPackage.Literals.COMPUTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Adapter> getAdapters() {
		if (adapters == null) {
			adapters = new EObjectResolvingEList<Adapter>(Adapter.class, this, Ma6icmodelPackage.COMPUTER__ADAPTERS);
		}
		return adapters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.COMPUTER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Telemetry> getTelemetry() {
		if (telemetry == null) {
			telemetry = new EObjectContainmentEList<Telemetry>(Telemetry.class, this, Ma6icmodelPackage.COMPUTER__TELEMETRY);
		}
		return telemetry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ma6icmodelPackage.COMPUTER__TELEMETRY:
				return ((InternalEList<?>)getTelemetry()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Ma6icmodelPackage.COMPUTER__ADAPTERS:
				return getAdapters();
			case Ma6icmodelPackage.COMPUTER__NAME:
				return getName();
			case Ma6icmodelPackage.COMPUTER__TELEMETRY:
				return getTelemetry();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Ma6icmodelPackage.COMPUTER__ADAPTERS:
				getAdapters().clear();
				getAdapters().addAll((Collection<? extends Adapter>)newValue);
				return;
			case Ma6icmodelPackage.COMPUTER__NAME:
				setName((String)newValue);
				return;
			case Ma6icmodelPackage.COMPUTER__TELEMETRY:
				getTelemetry().clear();
				getTelemetry().addAll((Collection<? extends Telemetry>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Ma6icmodelPackage.COMPUTER__ADAPTERS:
				getAdapters().clear();
				return;
			case Ma6icmodelPackage.COMPUTER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Ma6icmodelPackage.COMPUTER__TELEMETRY:
				getTelemetry().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Ma6icmodelPackage.COMPUTER__ADAPTERS:
				return adapters != null && !adapters.isEmpty();
			case Ma6icmodelPackage.COMPUTER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Ma6icmodelPackage.COMPUTER__TELEMETRY:
				return telemetry != null && !telemetry.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ComputerImpl
