/**
 */
package ma6icmodel.impl;

import ma6icmodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Ma6icmodelFactoryImpl extends EFactoryImpl implements Ma6icmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Ma6icmodelFactory init() {
		try {
			Ma6icmodelFactory theMa6icmodelFactory = (Ma6icmodelFactory)EPackage.Registry.INSTANCE.getEFactory(Ma6icmodelPackage.eNS_URI);
			if (theMa6icmodelFactory != null) {
				return theMa6icmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Ma6icmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ma6icmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Ma6icmodelPackage.MA6IC: return createMa6ic();
			case Ma6icmodelPackage.COMPUTER: return createComputer();
			case Ma6icmodelPackage.ADAPTER: return createAdapter();
			case Ma6icmodelPackage.SUBSYSTEM: return createSubsystem();
			case Ma6icmodelPackage.COMMAND: return createCommand();
			case Ma6icmodelPackage.TELEMETRY: return createTelemetry();
			case Ma6icmodelPackage.PACKET: return createPacket();
			case Ma6icmodelPackage.ERROR_TELEMETRY: return createErrorTelemetry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ma6ic createMa6ic() {
		Ma6icImpl ma6ic = new Ma6icImpl();
		return ma6ic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Computer createComputer() {
		ComputerImpl computer = new ComputerImpl();
		return computer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createAdapter() {
		AdapterImpl adapter = new AdapterImpl();
		return adapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subsystem createSubsystem() {
		SubsystemImpl subsystem = new SubsystemImpl();
		return subsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command createCommand() {
		CommandImpl command = new CommandImpl();
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Telemetry createTelemetry() {
		TelemetryImpl telemetry = new TelemetryImpl();
		return telemetry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Packet createPacket() {
		PacketImpl packet = new PacketImpl();
		return packet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorTelemetry createErrorTelemetry() {
		ErrorTelemetryImpl errorTelemetry = new ErrorTelemetryImpl();
		return errorTelemetry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ma6icmodelPackage getMa6icmodelPackage() {
		return (Ma6icmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Ma6icmodelPackage getPackage() {
		return Ma6icmodelPackage.eINSTANCE;
	}

} //Ma6icmodelFactoryImpl
