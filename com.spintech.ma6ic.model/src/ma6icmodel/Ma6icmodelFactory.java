/**
 */
package ma6icmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ma6icmodel.Ma6icmodelPackage
 * @generated
 */
public interface Ma6icmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Ma6icmodelFactory eINSTANCE = ma6icmodel.impl.Ma6icmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ma6ic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ma6ic</em>'.
	 * @generated
	 */
	Ma6ic createMa6ic();

	/**
	 * Returns a new object of class '<em>Computer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computer</em>'.
	 * @generated
	 */
	Computer createComputer();

	/**
	 * Returns a new object of class '<em>Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adapter</em>'.
	 * @generated
	 */
	Adapter createAdapter();

	/**
	 * Returns a new object of class '<em>Subsystem</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subsystem</em>'.
	 * @generated
	 */
	Subsystem createSubsystem();

	/**
	 * Returns a new object of class '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command</em>'.
	 * @generated
	 */
	Command createCommand();

	/**
	 * Returns a new object of class '<em>Telemetry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Telemetry</em>'.
	 * @generated
	 */
	Telemetry createTelemetry();

	/**
	 * Returns a new object of class '<em>Packet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Packet</em>'.
	 * @generated
	 */
	Packet createPacket();

	/**
	 * Returns a new object of class '<em>Error Telemetry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Telemetry</em>'.
	 * @generated
	 */
	ErrorTelemetry createErrorTelemetry();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Ma6icmodelPackage getMa6icmodelPackage();

} //Ma6icmodelFactory
