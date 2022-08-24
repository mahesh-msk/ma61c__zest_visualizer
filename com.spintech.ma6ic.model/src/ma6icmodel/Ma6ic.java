/**
 */
package ma6icmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ma6ic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ma6icmodel.Ma6ic#getComputer <em>Computer</em>}</li>
 *   <li>{@link ma6icmodel.Ma6ic#getName <em>Name</em>}</li>
 *   <li>{@link ma6icmodel.Ma6ic#getSubsystems <em>Subsystems</em>}</li>
 *   <li>{@link ma6icmodel.Ma6ic#getAdapters <em>Adapters</em>}</li>
 *   <li>{@link ma6icmodel.Ma6ic#getErrorTelemetries <em>Error Telemetries</em>}</li>
 * </ul>
 *
 * @see ma6icmodel.Ma6icmodelPackage#getMa6ic()
 * @model
 * @generated
 */
public interface Ma6ic extends EObject {
	/**
	 * Returns the value of the '<em><b>Computer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computer</em>' containment reference.
	 * @see #setComputer(Computer)
	 * @see ma6icmodel.Ma6icmodelPackage#getMa6ic_Computer()
	 * @model containment="true"
	 * @generated
	 */
	Computer getComputer();

	/**
	 * Sets the value of the '{@link ma6icmodel.Ma6ic#getComputer <em>Computer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computer</em>' containment reference.
	 * @see #getComputer()
	 * @generated
	 */
	void setComputer(Computer value);

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
	 * @see ma6icmodel.Ma6icmodelPackage#getMa6ic_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ma6icmodel.Ma6ic#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Subsystems</b></em>' containment reference list.
	 * The list contents are of type {@link ma6icmodel.Subsystem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsystems</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsystems</em>' containment reference list.
	 * @see ma6icmodel.Ma6icmodelPackage#getMa6ic_Subsystems()
	 * @model containment="true"
	 * @generated
	 */
	EList<Subsystem> getSubsystems();

	/**
	 * Returns the value of the '<em><b>Adapters</b></em>' containment reference list.
	 * The list contents are of type {@link ma6icmodel.Adapter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapters</em>' containment reference list.
	 * @see ma6icmodel.Ma6icmodelPackage#getMa6ic_Adapters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Adapter> getAdapters();

	/**
	 * Returns the value of the '<em><b>Error Telemetries</b></em>' containment reference list.
	 * The list contents are of type {@link ma6icmodel.ErrorTelemetry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Telemetries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Telemetries</em>' containment reference list.
	 * @see ma6icmodel.Ma6icmodelPackage#getMa6ic_ErrorTelemetries()
	 * @model containment="true"
	 * @generated
	 */
	EList<ErrorTelemetry> getErrorTelemetries();

} // Ma6ic
