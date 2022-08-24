/**
 */
package ma6icmodel.impl;

import ma6icmodel.Adapter;
import ma6icmodel.Command;
import ma6icmodel.Computer;
import ma6icmodel.ErrorTelemetry;
import ma6icmodel.Ma6ic;
import ma6icmodel.Ma6icmodelFactory;
import ma6icmodel.Ma6icmodelPackage;
import ma6icmodel.Packet;
import ma6icmodel.Subsystem;
import ma6icmodel.Telemetry;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Ma6icmodelPackageImpl extends EPackageImpl implements Ma6icmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ma6icEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adapterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subsystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass telemetryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorTelemetryEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see ma6icmodel.Ma6icmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Ma6icmodelPackageImpl() {
		super(eNS_URI, Ma6icmodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Ma6icmodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Ma6icmodelPackage init() {
		if (isInited) return (Ma6icmodelPackage)EPackage.Registry.INSTANCE.getEPackage(Ma6icmodelPackage.eNS_URI);

		// Obtain or create and register package
		Ma6icmodelPackageImpl theMa6icmodelPackage = (Ma6icmodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Ma6icmodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Ma6icmodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMa6icmodelPackage.createPackageContents();

		// Initialize created meta-data
		theMa6icmodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMa6icmodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Ma6icmodelPackage.eNS_URI, theMa6icmodelPackage);
		return theMa6icmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMa6ic() {
		return ma6icEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMa6ic_Computer() {
		return (EReference)ma6icEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMa6ic_Name() {
		return (EAttribute)ma6icEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMa6ic_Subsystems() {
		return (EReference)ma6icEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMa6ic_Adapters() {
		return (EReference)ma6icEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMa6ic_ErrorTelemetries() {
		return (EReference)ma6icEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputer() {
		return computerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputer_Adapters() {
		return (EReference)computerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComputer_Name() {
		return (EAttribute)computerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputer_Telemetry() {
		return (EReference)computerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdapter() {
		return adapterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapter_Telemetry() {
		return (EReference)adapterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdapter_Name() {
		return (EAttribute)adapterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapter_Subsystems() {
		return (EReference)adapterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdapter_NoOfPackets() {
		return (EAttribute)adapterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdapter_Valid() {
		return (EAttribute)adapterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdapter_TelemetrySize() {
		return (EAttribute)adapterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapter_Command() {
		return (EReference)adapterEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubsystem() {
		return subsystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubsystem_Telemetry() {
		return (EReference)subsystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubsystem_Packet() {
		return (EReference)subsystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubsystem_Name() {
		return (EAttribute)subsystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubsystem_Command() {
		return (EReference)subsystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubsystem_NoOfPackets() {
		return (EAttribute)subsystemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubsystem_Adapter() {
		return (EReference)subsystemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubsystem_Valid() {
		return (EAttribute)subsystemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubsystem_NoOfReceivedPacket() {
		return (EAttribute)subsystemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubsystem_TelemetrySize() {
		return (EAttribute)subsystemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommand() {
		return commandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommand_Telecommand() {
		return (EAttribute)commandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommand_ExecutionStatus() {
		return (EAttribute)commandEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommand_CommandDescription() {
		return (EAttribute)commandEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommand_CommandId() {
		return (EAttribute)commandEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommand_CommandData() {
		return (EAttribute)commandEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTelemetry() {
		return telemetryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelemetry_Parameter() {
		return (EAttribute)telemetryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelemetry_Description() {
		return (EAttribute)telemetryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelemetry_Value() {
		return (EAttribute)telemetryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelemetry_Unit() {
		return (EAttribute)telemetryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelemetry_Length() {
		return (EAttribute)telemetryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPacket() {
		return packetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPacket_Parameter() {
		return (EAttribute)packetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPacket_Description() {
		return (EAttribute)packetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPacket_Value() {
		return (EAttribute)packetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPacket_Unit() {
		return (EAttribute)packetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorTelemetry() {
		return errorTelemetryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorTelemetry_Telemetry() {
		return (EAttribute)errorTelemetryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorTelemetry_Error() {
		return (EAttribute)errorTelemetryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorTelemetry_Time() {
		return (EAttribute)errorTelemetryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ma6icmodelFactory getMa6icmodelFactory() {
		return (Ma6icmodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		ma6icEClass = createEClass(MA6IC);
		createEReference(ma6icEClass, MA6IC__COMPUTER);
		createEAttribute(ma6icEClass, MA6IC__NAME);
		createEReference(ma6icEClass, MA6IC__SUBSYSTEMS);
		createEReference(ma6icEClass, MA6IC__ADAPTERS);
		createEReference(ma6icEClass, MA6IC__ERROR_TELEMETRIES);

		computerEClass = createEClass(COMPUTER);
		createEReference(computerEClass, COMPUTER__ADAPTERS);
		createEAttribute(computerEClass, COMPUTER__NAME);
		createEReference(computerEClass, COMPUTER__TELEMETRY);

		adapterEClass = createEClass(ADAPTER);
		createEReference(adapterEClass, ADAPTER__TELEMETRY);
		createEAttribute(adapterEClass, ADAPTER__NAME);
		createEReference(adapterEClass, ADAPTER__SUBSYSTEMS);
		createEAttribute(adapterEClass, ADAPTER__NO_OF_PACKETS);
		createEAttribute(adapterEClass, ADAPTER__VALID);
		createEAttribute(adapterEClass, ADAPTER__TELEMETRY_SIZE);
		createEReference(adapterEClass, ADAPTER__COMMAND);

		subsystemEClass = createEClass(SUBSYSTEM);
		createEReference(subsystemEClass, SUBSYSTEM__TELEMETRY);
		createEReference(subsystemEClass, SUBSYSTEM__PACKET);
		createEAttribute(subsystemEClass, SUBSYSTEM__NAME);
		createEReference(subsystemEClass, SUBSYSTEM__COMMAND);
		createEAttribute(subsystemEClass, SUBSYSTEM__NO_OF_PACKETS);
		createEReference(subsystemEClass, SUBSYSTEM__ADAPTER);
		createEAttribute(subsystemEClass, SUBSYSTEM__VALID);
		createEAttribute(subsystemEClass, SUBSYSTEM__NO_OF_RECEIVED_PACKET);
		createEAttribute(subsystemEClass, SUBSYSTEM__TELEMETRY_SIZE);

		commandEClass = createEClass(COMMAND);
		createEAttribute(commandEClass, COMMAND__TELECOMMAND);
		createEAttribute(commandEClass, COMMAND__EXECUTION_STATUS);
		createEAttribute(commandEClass, COMMAND__COMMAND_DESCRIPTION);
		createEAttribute(commandEClass, COMMAND__COMMAND_ID);
		createEAttribute(commandEClass, COMMAND__COMMAND_DATA);

		telemetryEClass = createEClass(TELEMETRY);
		createEAttribute(telemetryEClass, TELEMETRY__PARAMETER);
		createEAttribute(telemetryEClass, TELEMETRY__DESCRIPTION);
		createEAttribute(telemetryEClass, TELEMETRY__VALUE);
		createEAttribute(telemetryEClass, TELEMETRY__UNIT);
		createEAttribute(telemetryEClass, TELEMETRY__LENGTH);

		packetEClass = createEClass(PACKET);
		createEAttribute(packetEClass, PACKET__PARAMETER);
		createEAttribute(packetEClass, PACKET__DESCRIPTION);
		createEAttribute(packetEClass, PACKET__VALUE);
		createEAttribute(packetEClass, PACKET__UNIT);

		errorTelemetryEClass = createEClass(ERROR_TELEMETRY);
		createEAttribute(errorTelemetryEClass, ERROR_TELEMETRY__TELEMETRY);
		createEAttribute(errorTelemetryEClass, ERROR_TELEMETRY__ERROR);
		createEAttribute(errorTelemetryEClass, ERROR_TELEMETRY__TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(ma6icEClass, Ma6ic.class, "Ma6ic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMa6ic_Computer(), this.getComputer(), null, "computer", null, 0, 1, Ma6ic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMa6ic_Name(), ecorePackage.getEString(), "name", null, 0, 1, Ma6ic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMa6ic_Subsystems(), this.getSubsystem(), null, "subsystems", null, 0, -1, Ma6ic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMa6ic_Adapters(), this.getAdapter(), null, "adapters", null, 0, -1, Ma6ic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMa6ic_ErrorTelemetries(), this.getErrorTelemetry(), null, "errorTelemetries", null, 0, -1, Ma6ic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computerEClass, Computer.class, "Computer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputer_Adapters(), this.getAdapter(), null, "adapters", null, 0, -1, Computer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComputer_Name(), ecorePackage.getEString(), "name", null, 0, 1, Computer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputer_Telemetry(), this.getTelemetry(), null, "telemetry", null, 0, -1, Computer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adapterEClass, Adapter.class, "Adapter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdapter_Telemetry(), this.getTelemetry(), null, "telemetry", null, 0, -1, Adapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdapter_Name(), ecorePackage.getEString(), "name", null, 0, 1, Adapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdapter_Subsystems(), this.getSubsystem(), this.getSubsystem_Adapter(), "subsystems", null, 0, -1, Adapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdapter_NoOfPackets(), ecorePackage.getEInt(), "noOfPackets", null, 0, -1, Adapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdapter_Valid(), ecorePackage.getEBoolean(), "valid", null, 0, 1, Adapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdapter_TelemetrySize(), ecorePackage.getEInt(), "telemetrySize", null, 0, 1, Adapter.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdapter_Command(), this.getCommand(), null, "command", null, 0, -1, Adapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subsystemEClass, Subsystem.class, "Subsystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubsystem_Telemetry(), this.getTelemetry(), null, "telemetry", null, 0, -1, Subsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubsystem_Packet(), this.getPacket(), null, "Packet", null, 0, 1, Subsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubsystem_Name(), ecorePackage.getEString(), "name", null, 0, 1, Subsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubsystem_Command(), this.getCommand(), null, "command", null, 0, -1, Subsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubsystem_NoOfPackets(), ecorePackage.getEInt(), "noOfPackets", null, 0, -1, Subsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubsystem_Adapter(), this.getAdapter(), this.getAdapter_Subsystems(), "adapter", null, 1, 1, Subsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubsystem_Valid(), ecorePackage.getEBoolean(), "valid", null, 0, 1, Subsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubsystem_NoOfReceivedPacket(), ecorePackage.getEInt(), "noOfReceivedPacket", null, 0, -1, Subsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubsystem_TelemetrySize(), ecorePackage.getEInt(), "telemetrySize", null, 0, 1, Subsystem.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandEClass, Command.class, "Command", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommand_Telecommand(), ecorePackage.getEString(), "telecommand", null, 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommand_ExecutionStatus(), ecorePackage.getEString(), "executionStatus", null, 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommand_CommandDescription(), ecorePackage.getEString(), "commandDescription", null, 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommand_CommandId(), ecorePackage.getEString(), "commandId", null, 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommand_CommandData(), ecorePackage.getEString(), "commandData", null, 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(telemetryEClass, Telemetry.class, "Telemetry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTelemetry_Parameter(), ecorePackage.getEString(), "parameter", null, 0, 1, Telemetry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTelemetry_Description(), ecorePackage.getEString(), "description", null, 0, 1, Telemetry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTelemetry_Value(), ecorePackage.getEString(), "value", null, 0, 1, Telemetry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTelemetry_Unit(), ecorePackage.getEString(), "unit", null, 0, 1, Telemetry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTelemetry_Length(), ecorePackage.getEInt(), "length", null, 0, 1, Telemetry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packetEClass, Packet.class, "Packet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPacket_Parameter(), ecorePackage.getEString(), "parameter", null, 0, 1, Packet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacket_Description(), ecorePackage.getEString(), "description", null, 0, 1, Packet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacket_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, Packet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacket_Unit(), ecorePackage.getEString(), "unit", null, 0, 1, Packet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorTelemetryEClass, ErrorTelemetry.class, "ErrorTelemetry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getErrorTelemetry_Telemetry(), ecorePackage.getEString(), "telemetry", null, 0, 1, ErrorTelemetry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorTelemetry_Error(), ecorePackage.getEString(), "error", null, 0, 1, ErrorTelemetry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorTelemetry_Time(), ecorePackage.getEDate(), "time", null, 0, 1, ErrorTelemetry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Ma6icmodelPackageImpl
