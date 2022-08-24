/**
 */
package ma6icmodel.impl;

import java.util.Collection;
import ma6icmodel.Adapter;
import ma6icmodel.Computer;
import ma6icmodel.ErrorTelemetry;
import ma6icmodel.Ma6ic;
import ma6icmodel.Ma6icmodelPackage;
import ma6icmodel.Subsystem;
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
 * An implementation of the model object '<em><b>Ma6ic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ma6icmodel.impl.Ma6icImpl#getComputer <em>Computer</em>}</li>
 *   <li>{@link ma6icmodel.impl.Ma6icImpl#getName <em>Name</em>}</li>
 *   <li>{@link ma6icmodel.impl.Ma6icImpl#getSubsystems <em>Subsystems</em>}</li>
 *   <li>{@link ma6icmodel.impl.Ma6icImpl#getAdapters <em>Adapters</em>}</li>
 *   <li>{@link ma6icmodel.impl.Ma6icImpl#getErrorTelemetries <em>Error Telemetries</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Ma6icImpl extends MinimalEObjectImpl.Container implements Ma6ic {
	/**
	 * The cached value of the '{@link #getComputer() <em>Computer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComputer()
	 * @generated
	 * @ordered
	 */
	protected Computer computer;

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
	 * The cached value of the '{@link #getSubsystems() <em>Subsystems</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsystems()
	 * @generated
	 * @ordered
	 */
	protected EList<Subsystem> subsystems;

	/**
	 * The cached value of the '{@link #getAdapters() <em>Adapters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapters()
	 * @generated
	 * @ordered
	 */
	protected EList<Adapter> adapters;

	/**
	 * The cached value of the '{@link #getErrorTelemetries() <em>Error Telemetries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorTelemetries()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorTelemetry> errorTelemetries;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Ma6icImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ma6icmodelPackage.Literals.MA6IC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Computer getComputer() {
		return computer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComputer(Computer newComputer, NotificationChain msgs) {
		Computer oldComputer = computer;
		computer = newComputer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.MA6IC__COMPUTER, oldComputer, newComputer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComputer(Computer newComputer) {
		if (newComputer != computer) {
			NotificationChain msgs = null;
			if (computer != null)
				msgs = ((InternalEObject)computer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Ma6icmodelPackage.MA6IC__COMPUTER, null, msgs);
			if (newComputer != null)
				msgs = ((InternalEObject)newComputer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Ma6icmodelPackage.MA6IC__COMPUTER, null, msgs);
			msgs = basicSetComputer(newComputer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.MA6IC__COMPUTER, newComputer, newComputer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.MA6IC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subsystem> getSubsystems() {
		if (subsystems == null) {
			subsystems = new EObjectContainmentEList<Subsystem>(Subsystem.class, this, Ma6icmodelPackage.MA6IC__SUBSYSTEMS);
		}
		return subsystems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Adapter> getAdapters() {
		if (adapters == null) {
			adapters = new EObjectContainmentEList<Adapter>(Adapter.class, this, Ma6icmodelPackage.MA6IC__ADAPTERS);
		}
		return adapters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ErrorTelemetry> getErrorTelemetries() {
		if (errorTelemetries == null) {
			errorTelemetries = new EObjectContainmentEList<ErrorTelemetry>(ErrorTelemetry.class, this, Ma6icmodelPackage.MA6IC__ERROR_TELEMETRIES);
		}
		return errorTelemetries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ma6icmodelPackage.MA6IC__COMPUTER:
				return basicSetComputer(null, msgs);
			case Ma6icmodelPackage.MA6IC__SUBSYSTEMS:
				return ((InternalEList<?>)getSubsystems()).basicRemove(otherEnd, msgs);
			case Ma6icmodelPackage.MA6IC__ADAPTERS:
				return ((InternalEList<?>)getAdapters()).basicRemove(otherEnd, msgs);
			case Ma6icmodelPackage.MA6IC__ERROR_TELEMETRIES:
				return ((InternalEList<?>)getErrorTelemetries()).basicRemove(otherEnd, msgs);
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
			case Ma6icmodelPackage.MA6IC__COMPUTER:
				return getComputer();
			case Ma6icmodelPackage.MA6IC__NAME:
				return getName();
			case Ma6icmodelPackage.MA6IC__SUBSYSTEMS:
				return getSubsystems();
			case Ma6icmodelPackage.MA6IC__ADAPTERS:
				return getAdapters();
			case Ma6icmodelPackage.MA6IC__ERROR_TELEMETRIES:
				return getErrorTelemetries();
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
			case Ma6icmodelPackage.MA6IC__COMPUTER:
				setComputer((Computer)newValue);
				return;
			case Ma6icmodelPackage.MA6IC__NAME:
				setName((String)newValue);
				return;
			case Ma6icmodelPackage.MA6IC__SUBSYSTEMS:
				getSubsystems().clear();
				getSubsystems().addAll((Collection<? extends Subsystem>)newValue);
				return;
			case Ma6icmodelPackage.MA6IC__ADAPTERS:
				getAdapters().clear();
				getAdapters().addAll((Collection<? extends Adapter>)newValue);
				return;
			case Ma6icmodelPackage.MA6IC__ERROR_TELEMETRIES:
				getErrorTelemetries().clear();
				getErrorTelemetries().addAll((Collection<? extends ErrorTelemetry>)newValue);
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
			case Ma6icmodelPackage.MA6IC__COMPUTER:
				setComputer((Computer)null);
				return;
			case Ma6icmodelPackage.MA6IC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Ma6icmodelPackage.MA6IC__SUBSYSTEMS:
				getSubsystems().clear();
				return;
			case Ma6icmodelPackage.MA6IC__ADAPTERS:
				getAdapters().clear();
				return;
			case Ma6icmodelPackage.MA6IC__ERROR_TELEMETRIES:
				getErrorTelemetries().clear();
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
			case Ma6icmodelPackage.MA6IC__COMPUTER:
				return computer != null;
			case Ma6icmodelPackage.MA6IC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Ma6icmodelPackage.MA6IC__SUBSYSTEMS:
				return subsystems != null && !subsystems.isEmpty();
			case Ma6icmodelPackage.MA6IC__ADAPTERS:
				return adapters != null && !adapters.isEmpty();
			case Ma6icmodelPackage.MA6IC__ERROR_TELEMETRIES:
				return errorTelemetries != null && !errorTelemetries.isEmpty();
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

} //Ma6icImpl
