/**
 */
package ma6icmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subsystem</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ma6icmodel.Subsystem#getTelemetry <em>Telemetry</em>}</li>
 *   <li>{@link ma6icmodel.Subsystem#getPacket <em>Packet</em>}</li>
 *   <li>{@link ma6icmodel.Subsystem#getName <em>Name</em>}</li>
 *   <li>{@link ma6icmodel.Subsystem#getCommand <em>Command</em>}</li>
 *   <li>{@link ma6icmodel.Subsystem#getNoOfPackets <em>No Of Packets</em>}</li>
 *   <li>{@link ma6icmodel.Subsystem#getAdapter <em>Adapter</em>}</li>
 *   <li>{@link ma6icmodel.Subsystem#isValid <em>Valid</em>}</li>
 *   <li>{@link ma6icmodel.Subsystem#getNoOfReceivedPacket <em>No Of Received Packet</em>}</li>
 *   <li>{@link ma6icmodel.Subsystem#getTelemetrySize <em>Telemetry Size</em>}</li>
 * </ul>
 *
 * @see ma6icmodel.Ma6icmodelPackage#getSubsystem()
 * @model
 * @generated
 */
public interface Subsystem extends EObject {
	/**
	 * Returns the value of the '<em><b>Telemetry</b></em>' containment reference list.
	 * The list contents are of type {@link ma6icmodel.Telemetry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Telemetry</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Telemetry</em>' containment reference list.
	 * @see ma6icmodel.Ma6icmodelPackage#getSubsystem_Telemetry()
	 * @model containment="true"
	 * @generated
	 */
	EList<Telemetry> getTelemetry();

	/**
	 * Returns the value of the '<em><b>Packet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packet</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packet</em>' containment reference.
	 * @see #setPacket(Packet)
	 * @see ma6icmodel.Ma6icmodelPackage#getSubsystem_Packet()
	 * @model containment="true"
	 * @generated
	 */
	Packet getPacket();

	/**
	 * Sets the value of the '{@link ma6icmodel.Subsystem#getPacket <em>Packet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Packet</em>' containment reference.
	 * @see #getPacket()
	 * @generated
	 */
	void setPacket(Packet value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ma6icmodel.Ma6icmodelPackage#getSubsystem_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ma6icmodel.Subsystem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Command</b></em>' containment reference list.
	 * The list contents are of type {@link ma6icmodel.Command}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command</em>' containment reference list.
	 * @see ma6icmodel.Ma6icmodelPackage#getSubsystem_Command()
	 * @model containment="true"
	 * @generated
	 */
	EList<Command> getCommand();

	/**
	 * Returns the value of the '<em><b>No Of Packets</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Of Packets</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Of Packets</em>' attribute list.
	 * @see ma6icmodel.Ma6icmodelPackage#getSubsystem_NoOfPackets()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getNoOfPackets();

	/**
	 * Returns the value of the '<em><b>Adapter</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link ma6icmodel.Adapter#getSubsystems <em>Subsystems</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapter</em>' reference.
	 * @see #setAdapter(Adapter)
	 * @see ma6icmodel.Ma6icmodelPackage#getSubsystem_Adapter()
	 * @see ma6icmodel.Adapter#getSubsystems
	 * @model opposite="subsystems" required="true"
	 * @generated
	 */
	Adapter getAdapter();

	/**
	 * Sets the value of the '{@link ma6icmodel.Subsystem#getAdapter <em>Adapter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adapter</em>' reference.
	 * @see #getAdapter()
	 * @generated
	 */
	void setAdapter(Adapter value);

	/**
	 * Returns the value of the '<em><b>Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid</em>' attribute.
	 * @see #setValid(boolean)
	 * @see ma6icmodel.Ma6icmodelPackage#getSubsystem_Valid()
	 * @model
	 * @generated
	 */
	boolean isValid();

	/**
	 * Sets the value of the '{@link ma6icmodel.Subsystem#isValid <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid</em>' attribute.
	 * @see #isValid()
	 * @generated
	 */
	void setValid(boolean value);

	/**
	 * Returns the value of the '<em><b>No Of Received Packet</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Of Received Packet</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Of Received Packet</em>' attribute list.
	 * @see ma6icmodel.Ma6icmodelPackage#getSubsystem_NoOfReceivedPacket()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getNoOfReceivedPacket();

	/**
	 * Returns the value of the '<em><b>Telemetry Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Telemetry Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Telemetry Size</em>' attribute.
	 * @see ma6icmodel.Ma6icmodelPackage#getSubsystem_TelemetrySize()
	 * @model changeable="false"
	 * @generated
	 */
	int getTelemetrySize();

} // Subsystem
