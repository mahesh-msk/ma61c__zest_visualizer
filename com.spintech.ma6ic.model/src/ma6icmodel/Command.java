/**
 */
package ma6icmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ma6icmodel.Command#getTelecommand <em>Telecommand</em>}</li>
 *   <li>{@link ma6icmodel.Command#getExecutionStatus <em>Execution Status</em>}</li>
 *   <li>{@link ma6icmodel.Command#getCommandDescription <em>Command Description</em>}</li>
 *   <li>{@link ma6icmodel.Command#getCommandId <em>Command Id</em>}</li>
 *   <li>{@link ma6icmodel.Command#getCommandData <em>Command Data</em>}</li>
 * </ul>
 *
 * @see ma6icmodel.Ma6icmodelPackage#getCommand()
 * @model
 * @generated
 */
public interface Command extends EObject {
	/**
	 * Returns the value of the '<em><b>Telecommand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Telecommand</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Telecommand</em>' attribute.
	 * @see #setTelecommand(String)
	 * @see ma6icmodel.Ma6icmodelPackage#getCommand_Telecommand()
	 * @model
	 * @generated
	 */
	String getTelecommand();

	/**
	 * Sets the value of the '{@link ma6icmodel.Command#getTelecommand <em>Telecommand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Telecommand</em>' attribute.
	 * @see #getTelecommand()
	 * @generated
	 */
	void setTelecommand(String value);

	/**
	 * Returns the value of the '<em><b>Execution Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Status</em>' attribute.
	 * @see #setExecutionStatus(String)
	 * @see ma6icmodel.Ma6icmodelPackage#getCommand_ExecutionStatus()
	 * @model
	 * @generated
	 */
	String getExecutionStatus();

	/**
	 * Sets the value of the '{@link ma6icmodel.Command#getExecutionStatus <em>Execution Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Status</em>' attribute.
	 * @see #getExecutionStatus()
	 * @generated
	 */
	void setExecutionStatus(String value);

	/**
	 * Returns the value of the '<em><b>Command Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Description</em>' attribute.
	 * @see #setCommandDescription(String)
	 * @see ma6icmodel.Ma6icmodelPackage#getCommand_CommandDescription()
	 * @model
	 * @generated
	 */
	String getCommandDescription();

	/**
	 * Sets the value of the '{@link ma6icmodel.Command#getCommandDescription <em>Command Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Description</em>' attribute.
	 * @see #getCommandDescription()
	 * @generated
	 */
	void setCommandDescription(String value);

	/**
	 * Returns the value of the '<em><b>Command Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Id</em>' attribute.
	 * @see #setCommandId(String)
	 * @see ma6icmodel.Ma6icmodelPackage#getCommand_CommandId()
	 * @model
	 * @generated
	 */
	String getCommandId();

	/**
	 * Sets the value of the '{@link ma6icmodel.Command#getCommandId <em>Command Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Id</em>' attribute.
	 * @see #getCommandId()
	 * @generated
	 */
	void setCommandId(String value);

	/**
	 * Returns the value of the '<em><b>Command Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Data</em>' attribute.
	 * @see #setCommandData(String)
	 * @see ma6icmodel.Ma6icmodelPackage#getCommand_CommandData()
	 * @model
	 * @generated
	 */
	String getCommandData();

	/**
	 * Sets the value of the '{@link ma6icmodel.Command#getCommandData <em>Command Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Data</em>' attribute.
	 * @see #getCommandData()
	 * @generated
	 */
	void setCommandData(String value);

} // Command
