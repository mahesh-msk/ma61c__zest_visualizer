/**
 */
package ma6icmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adapter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ma6icmodel.Adapter#getTelemetry <em>Telemetry</em>}</li>
 *   <li>{@link ma6icmodel.Adapter#getName <em>Name</em>}</li>
 *   <li>{@link ma6icmodel.Adapter#getSubsystems <em>Subsystems</em>}</li>
 *   <li>{@link ma6icmodel.Adapter#getNoOfPackets <em>No Of Packets</em>}</li>
 *   <li>{@link ma6icmodel.Adapter#isValid <em>Valid</em>}</li>
 *   <li>{@link ma6icmodel.Adapter#getTelemetrySize <em>Telemetry Size</em>}</li>
 *   <li>{@link ma6icmodel.Adapter#getCommand <em>Command</em>}</li>
 * </ul>
 *
 * @see ma6icmodel.Ma6icmodelPackage#getAdapter()
 * @model
 * @generated
 */
public interface Adapter extends EObject {
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
	 * @see ma6icmodel.Ma6icmodelPackage#getAdapter_Telemetry()
	 * @model containment="true"
	 * @generated
	 */
	EList<Telemetry> getTelemetry();

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
	 * @see ma6icmodel.Ma6icmodelPackage#getAdapter_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ma6icmodel.Adapter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Subsystems</b></em>' reference list.
	 * The list contents are of type {@link ma6icmodel.Subsystem}.
	 * It is bidirectional and its opposite is '{@link ma6icmodel.Subsystem#getAdapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsystems</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsystems</em>' reference list.
	 * @see ma6icmodel.Ma6icmodelPackage#getAdapter_Subsystems()
	 * @see ma6icmodel.Subsystem#getAdapter
	 * @model opposite="adapter"
	 * @generated
	 */
	EList<Subsystem> getSubsystems();

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
	 * @see ma6icmodel.Ma6icmodelPackage#getAdapter_NoOfPackets()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getNoOfPackets();

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
	 * @see ma6icmodel.Ma6icmodelPackage#getAdapter_Valid()
	 * @model
	 * @generated
	 */
	boolean isValid();

	/**
	 * Sets the value of the '{@link ma6icmodel.Adapter#isValid <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid</em>' attribute.
	 * @see #isValid()
	 * @generated
	 */
	void setValid(boolean value);

	/**
	 * Returns the value of the '<em><b>Telemetry Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Telemetry Size</em>' attribute.
	 * @see ma6icmodel.Ma6icmodelPackage#getAdapter_TelemetrySize()
	 * @model changeable="false"
	 * @generated
	 */
	int getTelemetrySize();

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
	 * @see ma6icmodel.Ma6icmodelPackage#getAdapter_Command()
	 * @model containment="true"
	 * @generated
	 */
	EList<Command> getCommand();

} // Adapter
