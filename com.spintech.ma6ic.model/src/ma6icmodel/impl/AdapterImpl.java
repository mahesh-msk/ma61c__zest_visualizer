/**
 */
package ma6icmodel.impl;

import java.util.Collection;
import ma6icmodel.Adapter;
import ma6icmodel.Command;
import ma6icmodel.Ma6icmodelPackage;
import ma6icmodel.Subsystem;
import ma6icmodel.Telemetry;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adapter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ma6icmodel.impl.AdapterImpl#getTelemetry <em>Telemetry</em>}</li>
 *   <li>{@link ma6icmodel.impl.AdapterImpl#getName <em>Name</em>}</li>
 *   <li>{@link ma6icmodel.impl.AdapterImpl#getSubsystems <em>Subsystems</em>}</li>
 *   <li>{@link ma6icmodel.impl.AdapterImpl#getNoOfPackets <em>No Of Packets</em>}</li>
 *   <li>{@link ma6icmodel.impl.AdapterImpl#isValid <em>Valid</em>}</li>
 *   <li>{@link ma6icmodel.impl.AdapterImpl#getTelemetrySize <em>Telemetry Size</em>}</li>
 *   <li>{@link ma6icmodel.impl.AdapterImpl#getCommand <em>Command</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdapterImpl extends MinimalEObjectImpl.Container implements Adapter {
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
	 * The cached value of the '{@link #getSubsystems() <em>Subsystems</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsystems()
	 * @generated
	 * @ordered
	 */
	protected EList<Subsystem> subsystems;

	/**
	 * The cached value of the '{@link #getNoOfPackets() <em>No Of Packets</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoOfPackets()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> noOfPackets;

	/**
	 * The default value of the '{@link #isValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValid()
	 * @generated
	 * @ordered
	 */
	protected boolean valid = VALID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTelemetrySize() <em>Telemetry Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelemetrySize()
	 * @generated
	 * @ordered
	 */
	protected static final int TELEMETRY_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTelemetrySize() <em>Telemetry Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelemetrySize()
	 * @generated
	 * @ordered
	 */
	protected int telemetrySize = TELEMETRY_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCommand() <em>Command</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected EList<Command> command;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdapterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ma6icmodelPackage.Literals.ADAPTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Telemetry> getTelemetry() {
		if (telemetry == null) {
			telemetry = new EObjectContainmentEList<Telemetry>(Telemetry.class, this, Ma6icmodelPackage.ADAPTER__TELEMETRY);
		}
		return telemetry;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.ADAPTER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subsystem> getSubsystems() {
		if (subsystems == null) {
			subsystems = new EObjectWithInverseResolvingEList<Subsystem>(Subsystem.class, this, Ma6icmodelPackage.ADAPTER__SUBSYSTEMS, Ma6icmodelPackage.SUBSYSTEM__ADAPTER);
		}
		return subsystems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getNoOfPackets() {
		if (noOfPackets == null) {
			noOfPackets = new EDataTypeEList<Integer>(Integer.class, this, Ma6icmodelPackage.ADAPTER__NO_OF_PACKETS);
		}
		return noOfPackets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValid(boolean newValid) {
		boolean oldValid = valid;
		valid = newValid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.ADAPTER__VALID, oldValid, valid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getTelemetrySize() {
		if(telemetrySize == 0) {
			EList<Telemetry> telemetries = getTelemetry();
			for (Telemetry telemetry : telemetries) {
				telemetrySize += telemetry.getLength();
			}
			return telemetrySize;
		}
		return telemetrySize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Command> getCommand() {
		if (command == null) {
			command = new EObjectContainmentEList<Command>(Command.class, this, Ma6icmodelPackage.ADAPTER__COMMAND);
		}
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ma6icmodelPackage.ADAPTER__SUBSYSTEMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubsystems()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ma6icmodelPackage.ADAPTER__TELEMETRY:
				return ((InternalEList<?>)getTelemetry()).basicRemove(otherEnd, msgs);
			case Ma6icmodelPackage.ADAPTER__SUBSYSTEMS:
				return ((InternalEList<?>)getSubsystems()).basicRemove(otherEnd, msgs);
			case Ma6icmodelPackage.ADAPTER__COMMAND:
				return ((InternalEList<?>)getCommand()).basicRemove(otherEnd, msgs);
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
			case Ma6icmodelPackage.ADAPTER__TELEMETRY:
				return getTelemetry();
			case Ma6icmodelPackage.ADAPTER__NAME:
				return getName();
			case Ma6icmodelPackage.ADAPTER__SUBSYSTEMS:
				return getSubsystems();
			case Ma6icmodelPackage.ADAPTER__NO_OF_PACKETS:
				return getNoOfPackets();
			case Ma6icmodelPackage.ADAPTER__VALID:
				return isValid();
			case Ma6icmodelPackage.ADAPTER__TELEMETRY_SIZE:
				return getTelemetrySize();
			case Ma6icmodelPackage.ADAPTER__COMMAND:
				return getCommand();
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
			case Ma6icmodelPackage.ADAPTER__TELEMETRY:
				getTelemetry().clear();
				getTelemetry().addAll((Collection<? extends Telemetry>)newValue);
				return;
			case Ma6icmodelPackage.ADAPTER__NAME:
				setName((String)newValue);
				return;
			case Ma6icmodelPackage.ADAPTER__SUBSYSTEMS:
				getSubsystems().clear();
				getSubsystems().addAll((Collection<? extends Subsystem>)newValue);
				return;
			case Ma6icmodelPackage.ADAPTER__NO_OF_PACKETS:
				getNoOfPackets().clear();
				getNoOfPackets().addAll((Collection<? extends Integer>)newValue);
				return;
			case Ma6icmodelPackage.ADAPTER__VALID:
				setValid((Boolean)newValue);
				return;
			case Ma6icmodelPackage.ADAPTER__COMMAND:
				getCommand().clear();
				getCommand().addAll((Collection<? extends Command>)newValue);
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
			case Ma6icmodelPackage.ADAPTER__TELEMETRY:
				getTelemetry().clear();
				return;
			case Ma6icmodelPackage.ADAPTER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Ma6icmodelPackage.ADAPTER__SUBSYSTEMS:
				getSubsystems().clear();
				return;
			case Ma6icmodelPackage.ADAPTER__NO_OF_PACKETS:
				getNoOfPackets().clear();
				return;
			case Ma6icmodelPackage.ADAPTER__VALID:
				setValid(VALID_EDEFAULT);
				return;
			case Ma6icmodelPackage.ADAPTER__COMMAND:
				getCommand().clear();
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
			case Ma6icmodelPackage.ADAPTER__TELEMETRY:
				return telemetry != null && !telemetry.isEmpty();
			case Ma6icmodelPackage.ADAPTER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Ma6icmodelPackage.ADAPTER__SUBSYSTEMS:
				return subsystems != null && !subsystems.isEmpty();
			case Ma6icmodelPackage.ADAPTER__NO_OF_PACKETS:
				return noOfPackets != null && !noOfPackets.isEmpty();
			case Ma6icmodelPackage.ADAPTER__VALID:
				return valid != VALID_EDEFAULT;
			case Ma6icmodelPackage.ADAPTER__TELEMETRY_SIZE:
				return telemetrySize != TELEMETRY_SIZE_EDEFAULT;
			case Ma6icmodelPackage.ADAPTER__COMMAND:
				return command != null && !command.isEmpty();
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
		result.append(", noOfPackets: ");
		result.append(noOfPackets);
		result.append(", valid: ");
		result.append(valid);
		result.append(", telemetrySize: ");
		result.append(telemetrySize);
		result.append(')');
		return result.toString();
	}

} //AdapterImpl
