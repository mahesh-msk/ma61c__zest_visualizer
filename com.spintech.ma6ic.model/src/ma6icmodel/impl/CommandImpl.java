/**
 */
package ma6icmodel.impl;

import ma6icmodel.Command;
import ma6icmodel.Ma6icmodelPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ma6icmodel.impl.CommandImpl#getTelecommand <em>Telecommand</em>}</li>
 *   <li>{@link ma6icmodel.impl.CommandImpl#getExecutionStatus <em>Execution Status</em>}</li>
 *   <li>{@link ma6icmodel.impl.CommandImpl#getCommandDescription <em>Command Description</em>}</li>
 *   <li>{@link ma6icmodel.impl.CommandImpl#getCommandId <em>Command Id</em>}</li>
 *   <li>{@link ma6icmodel.impl.CommandImpl#getCommandData <em>Command Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CommandImpl extends MinimalEObjectImpl.Container implements Command {
	/**
	 * The default value of the '{@link #getTelecommand() <em>Telecommand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelecommand()
	 * @generated
	 * @ordered
	 */
	protected static final String TELECOMMAND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTelecommand() <em>Telecommand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelecommand()
	 * @generated
	 * @ordered
	 */
	protected String telecommand = TELECOMMAND_EDEFAULT;

	/**
	 * The default value of the '{@link #getExecutionStatus() <em>Execution Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionStatus()
	 * @generated
	 * @ordered
	 */
	protected static final String EXECUTION_STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExecutionStatus() <em>Execution Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionStatus()
	 * @generated
	 * @ordered
	 */
	protected String executionStatus = EXECUTION_STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandDescription() <em>Command Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommandDescription() <em>Command Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandDescription()
	 * @generated
	 * @ordered
	 */
	protected String commandDescription = COMMAND_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandId() <em>Command Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandId()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommandId() <em>Command Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandId()
	 * @generated
	 * @ordered
	 */
	protected String commandId = COMMAND_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommandData() <em>Command Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandData()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommandData() <em>Command Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandData()
	 * @generated
	 * @ordered
	 */
	protected String commandData = COMMAND_DATA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ma6icmodelPackage.Literals.COMMAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTelecommand() {
		return telecommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTelecommand(String newTelecommand) {
		String oldTelecommand = telecommand;
		telecommand = newTelecommand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.COMMAND__TELECOMMAND, oldTelecommand, telecommand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExecutionStatus() {
		return executionStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionStatus(String newExecutionStatus) {
		String oldExecutionStatus = executionStatus;
		executionStatus = newExecutionStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.COMMAND__EXECUTION_STATUS, oldExecutionStatus, executionStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommandDescription() {
		return commandDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommandDescription(String newCommandDescription) {
		String oldCommandDescription = commandDescription;
		commandDescription = newCommandDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.COMMAND__COMMAND_DESCRIPTION, oldCommandDescription, commandDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommandId() {
		return commandId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommandId(String newCommandId) {
		String oldCommandId = commandId;
		commandId = newCommandId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.COMMAND__COMMAND_ID, oldCommandId, commandId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommandData() {
		return commandData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommandData(String newCommandData) {
		String oldCommandData = commandData;
		commandData = newCommandData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.COMMAND__COMMAND_DATA, oldCommandData, commandData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Ma6icmodelPackage.COMMAND__TELECOMMAND:
				return getTelecommand();
			case Ma6icmodelPackage.COMMAND__EXECUTION_STATUS:
				return getExecutionStatus();
			case Ma6icmodelPackage.COMMAND__COMMAND_DESCRIPTION:
				return getCommandDescription();
			case Ma6icmodelPackage.COMMAND__COMMAND_ID:
				return getCommandId();
			case Ma6icmodelPackage.COMMAND__COMMAND_DATA:
				return getCommandData();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Ma6icmodelPackage.COMMAND__TELECOMMAND:
				setTelecommand((String)newValue);
				return;
			case Ma6icmodelPackage.COMMAND__EXECUTION_STATUS:
				setExecutionStatus((String)newValue);
				return;
			case Ma6icmodelPackage.COMMAND__COMMAND_DESCRIPTION:
				setCommandDescription((String)newValue);
				return;
			case Ma6icmodelPackage.COMMAND__COMMAND_ID:
				setCommandId((String)newValue);
				return;
			case Ma6icmodelPackage.COMMAND__COMMAND_DATA:
				setCommandData((String)newValue);
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
			case Ma6icmodelPackage.COMMAND__TELECOMMAND:
				setTelecommand(TELECOMMAND_EDEFAULT);
				return;
			case Ma6icmodelPackage.COMMAND__EXECUTION_STATUS:
				setExecutionStatus(EXECUTION_STATUS_EDEFAULT);
				return;
			case Ma6icmodelPackage.COMMAND__COMMAND_DESCRIPTION:
				setCommandDescription(COMMAND_DESCRIPTION_EDEFAULT);
				return;
			case Ma6icmodelPackage.COMMAND__COMMAND_ID:
				setCommandId(COMMAND_ID_EDEFAULT);
				return;
			case Ma6icmodelPackage.COMMAND__COMMAND_DATA:
				setCommandData(COMMAND_DATA_EDEFAULT);
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
			case Ma6icmodelPackage.COMMAND__TELECOMMAND:
				return TELECOMMAND_EDEFAULT == null ? telecommand != null : !TELECOMMAND_EDEFAULT.equals(telecommand);
			case Ma6icmodelPackage.COMMAND__EXECUTION_STATUS:
				return EXECUTION_STATUS_EDEFAULT == null ? executionStatus != null : !EXECUTION_STATUS_EDEFAULT.equals(executionStatus);
			case Ma6icmodelPackage.COMMAND__COMMAND_DESCRIPTION:
				return COMMAND_DESCRIPTION_EDEFAULT == null ? commandDescription != null : !COMMAND_DESCRIPTION_EDEFAULT.equals(commandDescription);
			case Ma6icmodelPackage.COMMAND__COMMAND_ID:
				return COMMAND_ID_EDEFAULT == null ? commandId != null : !COMMAND_ID_EDEFAULT.equals(commandId);
			case Ma6icmodelPackage.COMMAND__COMMAND_DATA:
				return COMMAND_DATA_EDEFAULT == null ? commandData != null : !COMMAND_DATA_EDEFAULT.equals(commandData);
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
		result.append(" (telecommand: ");
		result.append(telecommand);
		result.append(", executionStatus: ");
		result.append(executionStatus);
		result.append(", commandDescription: ");
		result.append(commandDescription);
		result.append(", commandId: ");
		result.append(commandId);
		result.append(", commandData: ");
		result.append(commandData);
		result.append(')');
		return result.toString();
	}

} //CommandImpl
