/**
 */
package ma6icmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ma6icmodel.Computer#getAdapters <em>Adapters</em>}</li>
 *   <li>{@link ma6icmodel.Computer#getName <em>Name</em>}</li>
 *   <li>{@link ma6icmodel.Computer#getTelemetry <em>Telemetry</em>}</li>
 * </ul>
 *
 * @see ma6icmodel.Ma6icmodelPackage#getComputer()
 * @model
 * @generated
 */
public interface Computer extends EObject {
	/**
	 * Returns the value of the '<em><b>Adapters</b></em>' reference list.
	 * The list contents are of type {@link ma6icmodel.Adapter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapters</em>' reference list.
	 * @see ma6icmodel.Ma6icmodelPackage#getComputer_Adapters()
	 * @model
	 * @generated
	 */
	EList<Adapter> getAdapters();

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
	 * @see ma6icmodel.Ma6icmodelPackage#getComputer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ma6icmodel.Computer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see ma6icmodel.Ma6icmodelPackage#getComputer_Telemetry()
	 * @model containment="true"
	 * @generated
	 */
	EList<Telemetry> getTelemetry();

} // Computer
