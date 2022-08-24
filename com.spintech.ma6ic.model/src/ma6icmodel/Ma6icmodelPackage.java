/**
 */
package ma6icmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ma6icmodel.Ma6icmodelFactory
 * @model kind="package"
 * @generated
 */
public interface Ma6icmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ma6icmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ma6ic/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ma6ic";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Ma6icmodelPackage eINSTANCE = ma6icmodel.impl.Ma6icmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link ma6icmodel.impl.Ma6icImpl <em>Ma6ic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ma6icmodel.impl.Ma6icImpl
	 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getMa6ic()
	 * @generated
	 */
	int MA6IC = 0;

	/**
	 * The feature id for the '<em><b>Computer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MA6IC__COMPUTER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MA6IC__NAME = 1;

	/**
	 * The feature id for the '<em><b>Subsystems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MA6IC__SUBSYSTEMS = 2;

	/**
	 * The feature id for the '<em><b>Adapters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MA6IC__ADAPTERS = 3;

	/**
	 * The feature id for the '<em><b>Error Telemetries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MA6IC__ERROR_TELEMETRIES = 4;

	/**
	 * The number of structural features of the '<em>Ma6ic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MA6IC_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Ma6ic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MA6IC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ma6icmodel.impl.ComputerImpl <em>Computer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ma6icmodel.impl.ComputerImpl
	 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getComputer()
	 * @generated
	 */
	int COMPUTER = 1;

	/**
	 * The feature id for the '<em><b>Adapters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__ADAPTERS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Telemetry</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__TELEMETRY = 2;

	/**
	 * The number of structural features of the '<em>Computer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Computer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ma6icmodel.impl.AdapterImpl <em>Adapter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ma6icmodel.impl.AdapterImpl
	 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getAdapter()
	 * @generated
	 */
	int ADAPTER = 2;

	/**
	 * The feature id for the '<em><b>Telemetry</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__TELEMETRY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Subsystems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__SUBSYSTEMS = 2;

	/**
	 * The feature id for the '<em><b>No Of Packets</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__NO_OF_PACKETS = 3;

	/**
	 * The feature id for the '<em><b>Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__VALID = 4;

	/**
	 * The feature id for the '<em><b>Telemetry Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__TELEMETRY_SIZE = 5;

	/**
	 * The feature id for the '<em><b>Command</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__COMMAND = 6;

	/**
	 * The number of structural features of the '<em>Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ma6icmodel.impl.SubsystemImpl <em>Subsystem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ma6icmodel.impl.SubsystemImpl
	 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getSubsystem()
	 * @generated
	 */
	int SUBSYSTEM = 3;

	/**
	 * The feature id for the '<em><b>Telemetry</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__TELEMETRY = 0;

	/**
	 * The feature id for the '<em><b>Packet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__PACKET = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__NAME = 2;

	/**
	 * The feature id for the '<em><b>Command</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__COMMAND = 3;

	/**
	 * The feature id for the '<em><b>No Of Packets</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__NO_OF_PACKETS = 4;

	/**
	 * The feature id for the '<em><b>Adapter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__ADAPTER = 5;

	/**
	 * The feature id for the '<em><b>Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__VALID = 6;

	/**
	 * The feature id for the '<em><b>No Of Received Packet</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__NO_OF_RECEIVED_PACKET = 7;

	/**
	 * The feature id for the '<em><b>Telemetry Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__TELEMETRY_SIZE = 8;

	/**
	 * The number of structural features of the '<em>Subsystem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Subsystem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ma6icmodel.impl.CommandImpl <em>Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ma6icmodel.impl.CommandImpl
	 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getCommand()
	 * @generated
	 */
	int COMMAND = 4;

	/**
	 * The feature id for the '<em><b>Telecommand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__TELECOMMAND = 0;

	/**
	 * The feature id for the '<em><b>Execution Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__EXECUTION_STATUS = 1;

	/**
	 * The feature id for the '<em><b>Command Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__COMMAND_DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Command Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__COMMAND_ID = 3;

	/**
	 * The feature id for the '<em><b>Command Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__COMMAND_DATA = 4;

	/**
	 * The number of structural features of the '<em>Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ma6icmodel.impl.TelemetryImpl <em>Telemetry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ma6icmodel.impl.TelemetryImpl
	 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getTelemetry()
	 * @generated
	 */
	int TELEMETRY = 5;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMETRY__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMETRY__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMETRY__VALUE = 2;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMETRY__UNIT = 3;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMETRY__LENGTH = 4;

	/**
	 * The number of structural features of the '<em>Telemetry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMETRY_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Telemetry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMETRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ma6icmodel.impl.PacketImpl <em>Packet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ma6icmodel.impl.PacketImpl
	 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getPacket()
	 * @generated
	 */
	int PACKET = 6;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET__VALUE = 2;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET__UNIT = 3;

	/**
	 * The number of structural features of the '<em>Packet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Packet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link ma6icmodel.impl.ErrorTelemetryImpl <em>Error Telemetry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ma6icmodel.impl.ErrorTelemetryImpl
	 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getErrorTelemetry()
	 * @generated
	 */
	int ERROR_TELEMETRY = 7;

	/**
	 * The feature id for the '<em><b>Telemetry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_TELEMETRY__TELEMETRY = 0;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_TELEMETRY__ERROR = 1;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_TELEMETRY__TIME = 2;

	/**
	 * The number of structural features of the '<em>Error Telemetry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_TELEMETRY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Error Telemetry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_TELEMETRY_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link ma6icmodel.Ma6ic <em>Ma6ic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ma6ic</em>'.
	 * @see ma6icmodel.Ma6ic
	 * @generated
	 */
	EClass getMa6ic();

	/**
	 * Returns the meta object for the containment reference '{@link ma6icmodel.Ma6ic#getComputer <em>Computer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Computer</em>'.
	 * @see ma6icmodel.Ma6ic#getComputer()
	 * @see #getMa6ic()
	 * @generated
	 */
	EReference getMa6ic_Computer();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Ma6ic#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ma6icmodel.Ma6ic#getName()
	 * @see #getMa6ic()
	 * @generated
	 */
	EAttribute getMa6ic_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link ma6icmodel.Ma6ic#getSubsystems <em>Subsystems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subsystems</em>'.
	 * @see ma6icmodel.Ma6ic#getSubsystems()
	 * @see #getMa6ic()
	 * @generated
	 */
	EReference getMa6ic_Subsystems();

	/**
	 * Returns the meta object for the containment reference list '{@link ma6icmodel.Ma6ic#getAdapters <em>Adapters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Adapters</em>'.
	 * @see ma6icmodel.Ma6ic#getAdapters()
	 * @see #getMa6ic()
	 * @generated
	 */
	EReference getMa6ic_Adapters();

	/**
	 * Returns the meta object for the containment reference list '{@link ma6icmodel.Ma6ic#getErrorTelemetries <em>Error Telemetries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Error Telemetries</em>'.
	 * @see ma6icmodel.Ma6ic#getErrorTelemetries()
	 * @see #getMa6ic()
	 * @generated
	 */
	EReference getMa6ic_ErrorTelemetries();

	/**
	 * Returns the meta object for class '{@link ma6icmodel.Computer <em>Computer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computer</em>'.
	 * @see ma6icmodel.Computer
	 * @generated
	 */
	EClass getComputer();

	/**
	 * Returns the meta object for the reference list '{@link ma6icmodel.Computer#getAdapters <em>Adapters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Adapters</em>'.
	 * @see ma6icmodel.Computer#getAdapters()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_Adapters();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Computer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ma6icmodel.Computer#getName()
	 * @see #getComputer()
	 * @generated
	 */
	EAttribute getComputer_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link ma6icmodel.Computer#getTelemetry <em>Telemetry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Telemetry</em>'.
	 * @see ma6icmodel.Computer#getTelemetry()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_Telemetry();

	/**
	 * Returns the meta object for class '{@link ma6icmodel.Adapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter</em>'.
	 * @see ma6icmodel.Adapter
	 * @generated
	 */
	EClass getAdapter();

	/**
	 * Returns the meta object for the containment reference list '{@link ma6icmodel.Adapter#getTelemetry <em>Telemetry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Telemetry</em>'.
	 * @see ma6icmodel.Adapter#getTelemetry()
	 * @see #getAdapter()
	 * @generated
	 */
	EReference getAdapter_Telemetry();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Adapter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ma6icmodel.Adapter#getName()
	 * @see #getAdapter()
	 * @generated
	 */
	EAttribute getAdapter_Name();

	/**
	 * Returns the meta object for the reference list '{@link ma6icmodel.Adapter#getSubsystems <em>Subsystems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subsystems</em>'.
	 * @see ma6icmodel.Adapter#getSubsystems()
	 * @see #getAdapter()
	 * @generated
	 */
	EReference getAdapter_Subsystems();

	/**
	 * Returns the meta object for the attribute list '{@link ma6icmodel.Adapter#getNoOfPackets <em>No Of Packets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>No Of Packets</em>'.
	 * @see ma6icmodel.Adapter#getNoOfPackets()
	 * @see #getAdapter()
	 * @generated
	 */
	EAttribute getAdapter_NoOfPackets();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Adapter#isValid <em>Valid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid</em>'.
	 * @see ma6icmodel.Adapter#isValid()
	 * @see #getAdapter()
	 * @generated
	 */
	EAttribute getAdapter_Valid();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Adapter#getTelemetrySize <em>Telemetry Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Telemetry Size</em>'.
	 * @see ma6icmodel.Adapter#getTelemetrySize()
	 * @see #getAdapter()
	 * @generated
	 */
	EAttribute getAdapter_TelemetrySize();

	/**
	 * Returns the meta object for the containment reference list '{@link ma6icmodel.Adapter#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Command</em>'.
	 * @see ma6icmodel.Adapter#getCommand()
	 * @see #getAdapter()
	 * @generated
	 */
	EReference getAdapter_Command();

	/**
	 * Returns the meta object for class '{@link ma6icmodel.Subsystem <em>Subsystem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subsystem</em>'.
	 * @see ma6icmodel.Subsystem
	 * @generated
	 */
	EClass getSubsystem();

	/**
	 * Returns the meta object for the containment reference list '{@link ma6icmodel.Subsystem#getTelemetry <em>Telemetry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Telemetry</em>'.
	 * @see ma6icmodel.Subsystem#getTelemetry()
	 * @see #getSubsystem()
	 * @generated
	 */
	EReference getSubsystem_Telemetry();

	/**
	 * Returns the meta object for the containment reference '{@link ma6icmodel.Subsystem#getPacket <em>Packet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Packet</em>'.
	 * @see ma6icmodel.Subsystem#getPacket()
	 * @see #getSubsystem()
	 * @generated
	 */
	EReference getSubsystem_Packet();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Subsystem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ma6icmodel.Subsystem#getName()
	 * @see #getSubsystem()
	 * @generated
	 */
	EAttribute getSubsystem_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link ma6icmodel.Subsystem#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Command</em>'.
	 * @see ma6icmodel.Subsystem#getCommand()
	 * @see #getSubsystem()
	 * @generated
	 */
	EReference getSubsystem_Command();

	/**
	 * Returns the meta object for the attribute list '{@link ma6icmodel.Subsystem#getNoOfPackets <em>No Of Packets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>No Of Packets</em>'.
	 * @see ma6icmodel.Subsystem#getNoOfPackets()
	 * @see #getSubsystem()
	 * @generated
	 */
	EAttribute getSubsystem_NoOfPackets();

	/**
	 * Returns the meta object for the reference '{@link ma6icmodel.Subsystem#getAdapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Adapter</em>'.
	 * @see ma6icmodel.Subsystem#getAdapter()
	 * @see #getSubsystem()
	 * @generated
	 */
	EReference getSubsystem_Adapter();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Subsystem#isValid <em>Valid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid</em>'.
	 * @see ma6icmodel.Subsystem#isValid()
	 * @see #getSubsystem()
	 * @generated
	 */
	EAttribute getSubsystem_Valid();

	/**
	 * Returns the meta object for the attribute list '{@link ma6icmodel.Subsystem#getNoOfReceivedPacket <em>No Of Received Packet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>No Of Received Packet</em>'.
	 * @see ma6icmodel.Subsystem#getNoOfReceivedPacket()
	 * @see #getSubsystem()
	 * @generated
	 */
	EAttribute getSubsystem_NoOfReceivedPacket();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Subsystem#getTelemetrySize <em>Telemetry Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Telemetry Size</em>'.
	 * @see ma6icmodel.Subsystem#getTelemetrySize()
	 * @see #getSubsystem()
	 * @generated
	 */
	EAttribute getSubsystem_TelemetrySize();

	/**
	 * Returns the meta object for class '{@link ma6icmodel.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command</em>'.
	 * @see ma6icmodel.Command
	 * @generated
	 */
	EClass getCommand();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Command#getTelecommand <em>Telecommand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Telecommand</em>'.
	 * @see ma6icmodel.Command#getTelecommand()
	 * @see #getCommand()
	 * @generated
	 */
	EAttribute getCommand_Telecommand();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Command#getExecutionStatus <em>Execution Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Status</em>'.
	 * @see ma6icmodel.Command#getExecutionStatus()
	 * @see #getCommand()
	 * @generated
	 */
	EAttribute getCommand_ExecutionStatus();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Command#getCommandDescription <em>Command Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command Description</em>'.
	 * @see ma6icmodel.Command#getCommandDescription()
	 * @see #getCommand()
	 * @generated
	 */
	EAttribute getCommand_CommandDescription();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Command#getCommandId <em>Command Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command Id</em>'.
	 * @see ma6icmodel.Command#getCommandId()
	 * @see #getCommand()
	 * @generated
	 */
	EAttribute getCommand_CommandId();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Command#getCommandData <em>Command Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command Data</em>'.
	 * @see ma6icmodel.Command#getCommandData()
	 * @see #getCommand()
	 * @generated
	 */
	EAttribute getCommand_CommandData();

	/**
	 * Returns the meta object for class '{@link ma6icmodel.Telemetry <em>Telemetry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Telemetry</em>'.
	 * @see ma6icmodel.Telemetry
	 * @generated
	 */
	EClass getTelemetry();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Telemetry#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter</em>'.
	 * @see ma6icmodel.Telemetry#getParameter()
	 * @see #getTelemetry()
	 * @generated
	 */
	EAttribute getTelemetry_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Telemetry#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see ma6icmodel.Telemetry#getDescription()
	 * @see #getTelemetry()
	 * @generated
	 */
	EAttribute getTelemetry_Description();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Telemetry#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ma6icmodel.Telemetry#getValue()
	 * @see #getTelemetry()
	 * @generated
	 */
	EAttribute getTelemetry_Value();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Telemetry#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see ma6icmodel.Telemetry#getUnit()
	 * @see #getTelemetry()
	 * @generated
	 */
	EAttribute getTelemetry_Unit();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Telemetry#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see ma6icmodel.Telemetry#getLength()
	 * @see #getTelemetry()
	 * @generated
	 */
	EAttribute getTelemetry_Length();

	/**
	 * Returns the meta object for class '{@link ma6icmodel.Packet <em>Packet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Packet</em>'.
	 * @see ma6icmodel.Packet
	 * @generated
	 */
	EClass getPacket();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Packet#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter</em>'.
	 * @see ma6icmodel.Packet#getParameter()
	 * @see #getPacket()
	 * @generated
	 */
	EAttribute getPacket_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Packet#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see ma6icmodel.Packet#getDescription()
	 * @see #getPacket()
	 * @generated
	 */
	EAttribute getPacket_Description();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Packet#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ma6icmodel.Packet#getValue()
	 * @see #getPacket()
	 * @generated
	 */
	EAttribute getPacket_Value();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.Packet#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see ma6icmodel.Packet#getUnit()
	 * @see #getPacket()
	 * @generated
	 */
	EAttribute getPacket_Unit();

	/**
	 * Returns the meta object for class '{@link ma6icmodel.ErrorTelemetry <em>Error Telemetry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Telemetry</em>'.
	 * @see ma6icmodel.ErrorTelemetry
	 * @generated
	 */
	EClass getErrorTelemetry();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.ErrorTelemetry#getTelemetry <em>Telemetry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Telemetry</em>'.
	 * @see ma6icmodel.ErrorTelemetry#getTelemetry()
	 * @see #getErrorTelemetry()
	 * @generated
	 */
	EAttribute getErrorTelemetry_Telemetry();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.ErrorTelemetry#getError <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error</em>'.
	 * @see ma6icmodel.ErrorTelemetry#getError()
	 * @see #getErrorTelemetry()
	 * @generated
	 */
	EAttribute getErrorTelemetry_Error();

	/**
	 * Returns the meta object for the attribute '{@link ma6icmodel.ErrorTelemetry#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see ma6icmodel.ErrorTelemetry#getTime()
	 * @see #getErrorTelemetry()
	 * @generated
	 */
	EAttribute getErrorTelemetry_Time();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Ma6icmodelFactory getMa6icmodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ma6icmodel.impl.Ma6icImpl <em>Ma6ic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ma6icmodel.impl.Ma6icImpl
		 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getMa6ic()
		 * @generated
		 */
		EClass MA6IC = eINSTANCE.getMa6ic();

		/**
		 * The meta object literal for the '<em><b>Computer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MA6IC__COMPUTER = eINSTANCE.getMa6ic_Computer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MA6IC__NAME = eINSTANCE.getMa6ic_Name();

		/**
		 * The meta object literal for the '<em><b>Subsystems</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MA6IC__SUBSYSTEMS = eINSTANCE.getMa6ic_Subsystems();

		/**
		 * The meta object literal for the '<em><b>Adapters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MA6IC__ADAPTERS = eINSTANCE.getMa6ic_Adapters();

		/**
		 * The meta object literal for the '<em><b>Error Telemetries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MA6IC__ERROR_TELEMETRIES = eINSTANCE.getMa6ic_ErrorTelemetries();

		/**
		 * The meta object literal for the '{@link ma6icmodel.impl.ComputerImpl <em>Computer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ma6icmodel.impl.ComputerImpl
		 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getComputer()
		 * @generated
		 */
		EClass COMPUTER = eINSTANCE.getComputer();

		/**
		 * The meta object literal for the '<em><b>Adapters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTER__ADAPTERS = eINSTANCE.getComputer_Adapters();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTER__NAME = eINSTANCE.getComputer_Name();

		/**
		 * The meta object literal for the '<em><b>Telemetry</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTER__TELEMETRY = eINSTANCE.getComputer_Telemetry();

		/**
		 * The meta object literal for the '{@link ma6icmodel.impl.AdapterImpl <em>Adapter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ma6icmodel.impl.AdapterImpl
		 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getAdapter()
		 * @generated
		 */
		EClass ADAPTER = eINSTANCE.getAdapter();

		/**
		 * The meta object literal for the '<em><b>Telemetry</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER__TELEMETRY = eINSTANCE.getAdapter_Telemetry();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER__NAME = eINSTANCE.getAdapter_Name();

		/**
		 * The meta object literal for the '<em><b>Subsystems</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER__SUBSYSTEMS = eINSTANCE.getAdapter_Subsystems();

		/**
		 * The meta object literal for the '<em><b>No Of Packets</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER__NO_OF_PACKETS = eINSTANCE.getAdapter_NoOfPackets();

		/**
		 * The meta object literal for the '<em><b>Valid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER__VALID = eINSTANCE.getAdapter_Valid();

		/**
		 * The meta object literal for the '<em><b>Telemetry Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER__TELEMETRY_SIZE = eINSTANCE.getAdapter_TelemetrySize();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER__COMMAND = eINSTANCE.getAdapter_Command();

		/**
		 * The meta object literal for the '{@link ma6icmodel.impl.SubsystemImpl <em>Subsystem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ma6icmodel.impl.SubsystemImpl
		 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getSubsystem()
		 * @generated
		 */
		EClass SUBSYSTEM = eINSTANCE.getSubsystem();

		/**
		 * The meta object literal for the '<em><b>Telemetry</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM__TELEMETRY = eINSTANCE.getSubsystem_Telemetry();

		/**
		 * The meta object literal for the '<em><b>Packet</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM__PACKET = eINSTANCE.getSubsystem_Packet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBSYSTEM__NAME = eINSTANCE.getSubsystem_Name();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM__COMMAND = eINSTANCE.getSubsystem_Command();

		/**
		 * The meta object literal for the '<em><b>No Of Packets</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBSYSTEM__NO_OF_PACKETS = eINSTANCE.getSubsystem_NoOfPackets();

		/**
		 * The meta object literal for the '<em><b>Adapter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM__ADAPTER = eINSTANCE.getSubsystem_Adapter();

		/**
		 * The meta object literal for the '<em><b>Valid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBSYSTEM__VALID = eINSTANCE.getSubsystem_Valid();

		/**
		 * The meta object literal for the '<em><b>No Of Received Packet</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBSYSTEM__NO_OF_RECEIVED_PACKET = eINSTANCE.getSubsystem_NoOfReceivedPacket();

		/**
		 * The meta object literal for the '<em><b>Telemetry Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBSYSTEM__TELEMETRY_SIZE = eINSTANCE.getSubsystem_TelemetrySize();

		/**
		 * The meta object literal for the '{@link ma6icmodel.impl.CommandImpl <em>Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ma6icmodel.impl.CommandImpl
		 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getCommand()
		 * @generated
		 */
		EClass COMMAND = eINSTANCE.getCommand();

		/**
		 * The meta object literal for the '<em><b>Telecommand</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND__TELECOMMAND = eINSTANCE.getCommand_Telecommand();

		/**
		 * The meta object literal for the '<em><b>Execution Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND__EXECUTION_STATUS = eINSTANCE.getCommand_ExecutionStatus();

		/**
		 * The meta object literal for the '<em><b>Command Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND__COMMAND_DESCRIPTION = eINSTANCE.getCommand_CommandDescription();

		/**
		 * The meta object literal for the '<em><b>Command Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND__COMMAND_ID = eINSTANCE.getCommand_CommandId();

		/**
		 * The meta object literal for the '<em><b>Command Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND__COMMAND_DATA = eINSTANCE.getCommand_CommandData();

		/**
		 * The meta object literal for the '{@link ma6icmodel.impl.TelemetryImpl <em>Telemetry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ma6icmodel.impl.TelemetryImpl
		 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getTelemetry()
		 * @generated
		 */
		EClass TELEMETRY = eINSTANCE.getTelemetry();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TELEMETRY__PARAMETER = eINSTANCE.getTelemetry_Parameter();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TELEMETRY__DESCRIPTION = eINSTANCE.getTelemetry_Description();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TELEMETRY__VALUE = eINSTANCE.getTelemetry_Value();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TELEMETRY__UNIT = eINSTANCE.getTelemetry_Unit();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TELEMETRY__LENGTH = eINSTANCE.getTelemetry_Length();

		/**
		 * The meta object literal for the '{@link ma6icmodel.impl.PacketImpl <em>Packet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ma6icmodel.impl.PacketImpl
		 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getPacket()
		 * @generated
		 */
		EClass PACKET = eINSTANCE.getPacket();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET__PARAMETER = eINSTANCE.getPacket_Parameter();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET__DESCRIPTION = eINSTANCE.getPacket_Description();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET__VALUE = eINSTANCE.getPacket_Value();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET__UNIT = eINSTANCE.getPacket_Unit();

		/**
		 * The meta object literal for the '{@link ma6icmodel.impl.ErrorTelemetryImpl <em>Error Telemetry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ma6icmodel.impl.ErrorTelemetryImpl
		 * @see ma6icmodel.impl.Ma6icmodelPackageImpl#getErrorTelemetry()
		 * @generated
		 */
		EClass ERROR_TELEMETRY = eINSTANCE.getErrorTelemetry();

		/**
		 * The meta object literal for the '<em><b>Telemetry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_TELEMETRY__TELEMETRY = eINSTANCE.getErrorTelemetry_Telemetry();

		/**
		 * The meta object literal for the '<em><b>Error</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_TELEMETRY__ERROR = eINSTANCE.getErrorTelemetry_Error();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_TELEMETRY__TIME = eINSTANCE.getErrorTelemetry_Time();

	}

} //Ma6icmodelPackage
