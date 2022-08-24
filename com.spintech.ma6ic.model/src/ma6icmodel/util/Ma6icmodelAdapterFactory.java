/**
 */
package ma6icmodel.util;

import ma6icmodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ma6icmodel.Ma6icmodelPackage
 * @generated
 */
public class Ma6icmodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Ma6icmodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ma6icmodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Ma6icmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Ma6icmodelSwitch<Adapter> modelSwitch =
		new Ma6icmodelSwitch<Adapter>() {
			@Override
			public Adapter caseMa6ic(Ma6ic object) {
				return createMa6icAdapter();
			}
			@Override
			public Adapter caseComputer(Computer object) {
				return createComputerAdapter();
			}
			@Override
			public Adapter caseAdapter(ma6icmodel.Adapter object) {
				return createAdapterAdapter();
			}
			@Override
			public Adapter caseSubsystem(Subsystem object) {
				return createSubsystemAdapter();
			}
			@Override
			public Adapter caseCommand(Command object) {
				return createCommandAdapter();
			}
			@Override
			public Adapter caseTelemetry(Telemetry object) {
				return createTelemetryAdapter();
			}
			@Override
			public Adapter casePacket(Packet object) {
				return createPacketAdapter();
			}
			@Override
			public Adapter caseErrorTelemetry(ErrorTelemetry object) {
				return createErrorTelemetryAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link ma6icmodel.Ma6ic <em>Ma6ic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ma6icmodel.Ma6ic
	 * @generated
	 */
	public Adapter createMa6icAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ma6icmodel.Computer <em>Computer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ma6icmodel.Computer
	 * @generated
	 */
	public Adapter createComputerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ma6icmodel.Adapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ma6icmodel.Adapter
	 * @generated
	 */
	public Adapter createAdapterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ma6icmodel.Subsystem <em>Subsystem</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ma6icmodel.Subsystem
	 * @generated
	 */
	public Adapter createSubsystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ma6icmodel.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ma6icmodel.Command
	 * @generated
	 */
	public Adapter createCommandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ma6icmodel.Telemetry <em>Telemetry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ma6icmodel.Telemetry
	 * @generated
	 */
	public Adapter createTelemetryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ma6icmodel.Packet <em>Packet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ma6icmodel.Packet
	 * @generated
	 */
	public Adapter createPacketAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ma6icmodel.ErrorTelemetry <em>Error Telemetry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ma6icmodel.ErrorTelemetry
	 * @generated
	 */
	public Adapter createErrorTelemetryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Ma6icmodelAdapterFactory
