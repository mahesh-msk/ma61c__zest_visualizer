/**
 */
package ma6icmodel.impl;

import java.util.Collection;
import ma6icmodel.Adapter;
import ma6icmodel.Command;
import ma6icmodel.Ma6icmodelPackage;
import ma6icmodel.Packet;
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
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subsystem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ma6icmodel.impl.SubsystemImpl#getTelemetry <em>Telemetry</em>}</li>
 *   <li>{@link ma6icmodel.impl.SubsystemImpl#getPacket <em>Packet</em>}</li>
 *   <li>{@link ma6icmodel.impl.SubsystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link ma6icmodel.impl.SubsystemImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link ma6icmodel.impl.SubsystemImpl#getNoOfPackets <em>No Of Packets</em>}</li>
 *   <li>{@link ma6icmodel.impl.SubsystemImpl#getAdapter <em>Adapter</em>}</li>
 *   <li>{@link ma6icmodel.impl.SubsystemImpl#isValid <em>Valid</em>}</li>
 *   <li>{@link ma6icmodel.impl.SubsystemImpl#getNoOfReceivedPacket <em>No Of Received Packet</em>}</li>
 *   <li>{@link ma6icmodel.impl.SubsystemImpl#getTelemetrySize <em>Telemetry Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubsystemImpl extends MinimalEObjectImpl.Container implements Subsystem {
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
	 * The cached value of the '{@link #getPacket() <em>Packet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPacket()
	 * @generated
	 * @ordered
	 */
	protected Packet packet;

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
	 * The cached value of the '{@link #getCommand() <em>Command</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected EList<Command> command;

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
	 * The cached value of the '{@link #getAdapter() <em>Adapter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapter()
	 * @generated
	 * @ordered
	 */
	protected Adapter adapter;

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
	 * The cached value of the '{@link #getNoOfReceivedPacket() <em>No Of Received Packet</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoOfReceivedPacket()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> noOfReceivedPacket;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubsystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ma6icmodelPackage.Literals.SUBSYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Telemetry> getTelemetry() {
		if (telemetry == null) {
			telemetry = new EObjectContainmentEList<Telemetry>(Telemetry.class, this, Ma6icmodelPackage.SUBSYSTEM__TELEMETRY);
		}
		return telemetry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Packet getPacket() {
		return packet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPacket(Packet newPacket, NotificationChain msgs) {
		Packet oldPacket = packet;
		packet = newPacket;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.SUBSYSTEM__PACKET, oldPacket, newPacket);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPacket(Packet newPacket) {
		if (newPacket != packet) {
			NotificationChain msgs = null;
			if (packet != null)
				msgs = ((InternalEObject)packet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Ma6icmodelPackage.SUBSYSTEM__PACKET, null, msgs);
			if (newPacket != null)
				msgs = ((InternalEObject)newPacket).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Ma6icmodelPackage.SUBSYSTEM__PACKET, null, msgs);
			msgs = basicSetPacket(newPacket, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.SUBSYSTEM__PACKET, newPacket, newPacket));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.SUBSYSTEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Command> getCommand() {
		if (command == null) {
			command = new EObjectContainmentEList<Command>(Command.class, this, Ma6icmodelPackage.SUBSYSTEM__COMMAND);
		}
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getNoOfPackets() {
		if (noOfPackets == null) {
			noOfPackets = new EDataTypeEList<Integer>(Integer.class, this, Ma6icmodelPackage.SUBSYSTEM__NO_OF_PACKETS);
		}
		return noOfPackets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter getAdapter() {
		if (adapter != null && adapter.eIsProxy()) {
			InternalEObject oldAdapter = (InternalEObject)adapter;
			adapter = (Adapter)eResolveProxy(oldAdapter);
			if (adapter != oldAdapter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ma6icmodelPackage.SUBSYSTEM__ADAPTER, oldAdapter, adapter));
			}
		}
		return adapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter basicGetAdapter() {
		return adapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdapter(Adapter newAdapter, NotificationChain msgs) {
		Adapter oldAdapter = adapter;
		adapter = newAdapter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.SUBSYSTEM__ADAPTER, oldAdapter, newAdapter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdapter(Adapter newAdapter) {
		if (newAdapter != adapter) {
			NotificationChain msgs = null;
			if (adapter != null)
				msgs = ((InternalEObject)adapter).eInverseRemove(this, Ma6icmodelPackage.ADAPTER__SUBSYSTEMS, Adapter.class, msgs);
			if (newAdapter != null)
				msgs = ((InternalEObject)newAdapter).eInverseAdd(this, Ma6icmodelPackage.ADAPTER__SUBSYSTEMS, Adapter.class, msgs);
			msgs = basicSetAdapter(newAdapter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.SUBSYSTEM__ADAPTER, newAdapter, newAdapter));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.SUBSYSTEM__VALID, oldValid, valid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getNoOfReceivedPacket() {
		if (noOfReceivedPacket == null) {
			noOfReceivedPacket = new EDataTypeEList<Integer>(Integer.class, this, Ma6icmodelPackage.SUBSYSTEM__NO_OF_RECEIVED_PACKET);
		}
		return noOfReceivedPacket;
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
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ma6icmodelPackage.SUBSYSTEM__ADAPTER:
				if (adapter != null)
					msgs = ((InternalEObject)adapter).eInverseRemove(this, Ma6icmodelPackage.ADAPTER__SUBSYSTEMS, Adapter.class, msgs);
				return basicSetAdapter((Adapter)otherEnd, msgs);
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
			case Ma6icmodelPackage.SUBSYSTEM__TELEMETRY:
				return ((InternalEList<?>)getTelemetry()).basicRemove(otherEnd, msgs);
			case Ma6icmodelPackage.SUBSYSTEM__PACKET:
				return basicSetPacket(null, msgs);
			case Ma6icmodelPackage.SUBSYSTEM__COMMAND:
				return ((InternalEList<?>)getCommand()).basicRemove(otherEnd, msgs);
			case Ma6icmodelPackage.SUBSYSTEM__ADAPTER:
				return basicSetAdapter(null, msgs);
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
			case Ma6icmodelPackage.SUBSYSTEM__TELEMETRY:
				return getTelemetry();
			case Ma6icmodelPackage.SUBSYSTEM__PACKET:
				return getPacket();
			case Ma6icmodelPackage.SUBSYSTEM__NAME:
				return getName();
			case Ma6icmodelPackage.SUBSYSTEM__COMMAND:
				return getCommand();
			case Ma6icmodelPackage.SUBSYSTEM__NO_OF_PACKETS:
				return getNoOfPackets();
			case Ma6icmodelPackage.SUBSYSTEM__ADAPTER:
				if (resolve) return getAdapter();
				return basicGetAdapter();
			case Ma6icmodelPackage.SUBSYSTEM__VALID:
				return isValid();
			case Ma6icmodelPackage.SUBSYSTEM__NO_OF_RECEIVED_PACKET:
				return getNoOfReceivedPacket();
			case Ma6icmodelPackage.SUBSYSTEM__TELEMETRY_SIZE:
				return getTelemetrySize();
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
			case Ma6icmodelPackage.SUBSYSTEM__TELEMETRY:
				getTelemetry().clear();
				getTelemetry().addAll((Collection<? extends Telemetry>)newValue);
				return;
			case Ma6icmodelPackage.SUBSYSTEM__PACKET:
				setPacket((Packet)newValue);
				return;
			case Ma6icmodelPackage.SUBSYSTEM__NAME:
				setName((String)newValue);
				return;
			case Ma6icmodelPackage.SUBSYSTEM__COMMAND:
				getCommand().clear();
				getCommand().addAll((Collection<? extends Command>)newValue);
				return;
			case Ma6icmodelPackage.SUBSYSTEM__NO_OF_PACKETS:
				getNoOfPackets().clear();
				getNoOfPackets().addAll((Collection<? extends Integer>)newValue);
				return;
			case Ma6icmodelPackage.SUBSYSTEM__ADAPTER:
				setAdapter((Adapter)newValue);
				return;
			case Ma6icmodelPackage.SUBSYSTEM__VALID:
				setValid((Boolean)newValue);
				return;
			case Ma6icmodelPackage.SUBSYSTEM__NO_OF_RECEIVED_PACKET:
				getNoOfReceivedPacket().clear();
				getNoOfReceivedPacket().addAll((Collection<? extends Integer>)newValue);
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
			case Ma6icmodelPackage.SUBSYSTEM__TELEMETRY:
				getTelemetry().clear();
				return;
			case Ma6icmodelPackage.SUBSYSTEM__PACKET:
				setPacket((Packet)null);
				return;
			case Ma6icmodelPackage.SUBSYSTEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Ma6icmodelPackage.SUBSYSTEM__COMMAND:
				getCommand().clear();
				return;
			case Ma6icmodelPackage.SUBSYSTEM__NO_OF_PACKETS:
				getNoOfPackets().clear();
				return;
			case Ma6icmodelPackage.SUBSYSTEM__ADAPTER:
				setAdapter((Adapter)null);
				return;
			case Ma6icmodelPackage.SUBSYSTEM__VALID:
				setValid(VALID_EDEFAULT);
				return;
			case Ma6icmodelPackage.SUBSYSTEM__NO_OF_RECEIVED_PACKET:
				getNoOfReceivedPacket().clear();
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
			case Ma6icmodelPackage.SUBSYSTEM__TELEMETRY:
				return telemetry != null && !telemetry.isEmpty();
			case Ma6icmodelPackage.SUBSYSTEM__PACKET:
				return packet != null;
			case Ma6icmodelPackage.SUBSYSTEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Ma6icmodelPackage.SUBSYSTEM__COMMAND:
				return command != null && !command.isEmpty();
			case Ma6icmodelPackage.SUBSYSTEM__NO_OF_PACKETS:
				return noOfPackets != null && !noOfPackets.isEmpty();
			case Ma6icmodelPackage.SUBSYSTEM__ADAPTER:
				return adapter != null;
			case Ma6icmodelPackage.SUBSYSTEM__VALID:
				return valid != VALID_EDEFAULT;
			case Ma6icmodelPackage.SUBSYSTEM__NO_OF_RECEIVED_PACKET:
				return noOfReceivedPacket != null && !noOfReceivedPacket.isEmpty();
			case Ma6icmodelPackage.SUBSYSTEM__TELEMETRY_SIZE:
				return telemetrySize != TELEMETRY_SIZE_EDEFAULT;
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
		result.append(", noOfReceivedPacket: ");
		result.append(noOfReceivedPacket);
		result.append(", telemetrySize: ");
		result.append(telemetrySize);
		result.append(')');
		return result.toString();
	}

} //SubsystemImpl
