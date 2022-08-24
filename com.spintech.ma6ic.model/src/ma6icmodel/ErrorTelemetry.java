/**
 */
package ma6icmodel;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Telemetry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ma6icmodel.ErrorTelemetry#getTelemetry <em>Telemetry</em>}</li>
 *   <li>{@link ma6icmodel.ErrorTelemetry#getError <em>Error</em>}</li>
 *   <li>{@link ma6icmodel.ErrorTelemetry#getTime <em>Time</em>}</li>
 * </ul>
 *
 * @see ma6icmodel.Ma6icmodelPackage#getErrorTelemetry()
 * @model
 * @generated
 */
public interface ErrorTelemetry extends EObject {
	/**
	 * Returns the value of the '<em><b>Telemetry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Telemetry</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Telemetry</em>' attribute.
	 * @see #setTelemetry(String)
	 * @see ma6icmodel.Ma6icmodelPackage#getErrorTelemetry_Telemetry()
	 * @model
	 * @generated
	 */
	String getTelemetry();

	/**
	 * Sets the value of the '{@link ma6icmodel.ErrorTelemetry#getTelemetry <em>Telemetry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Telemetry</em>' attribute.
	 * @see #getTelemetry()
	 * @generated
	 */
	void setTelemetry(String value);

	/**
	 * Returns the value of the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error</em>' attribute.
	 * @see #setError(String)
	 * @see ma6icmodel.Ma6icmodelPackage#getErrorTelemetry_Error()
	 * @model
	 * @generated
	 */
	String getError();

	/**
	 * Sets the value of the '{@link ma6icmodel.ErrorTelemetry#getError <em>Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error</em>' attribute.
	 * @see #getError()
	 * @generated
	 */
	void setError(String value);

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(Date)
	 * @see ma6icmodel.Ma6icmodelPackage#getErrorTelemetry_Time()
	 * @model
	 * @generated
	 */
	Date getTime();

	/**
	 * Sets the value of the '{@link ma6icmodel.ErrorTelemetry#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(Date value);

} // ErrorTelemetry
