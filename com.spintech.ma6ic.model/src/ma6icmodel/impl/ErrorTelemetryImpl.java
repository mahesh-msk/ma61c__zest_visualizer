/**
 */
package ma6icmodel.impl;

import java.util.Date;

import ma6icmodel.ErrorTelemetry;
import ma6icmodel.Ma6icmodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Telemetry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ma6icmodel.impl.ErrorTelemetryImpl#getTelemetry <em>Telemetry</em>}</li>
 *   <li>{@link ma6icmodel.impl.ErrorTelemetryImpl#getError <em>Error</em>}</li>
 *   <li>{@link ma6icmodel.impl.ErrorTelemetryImpl#getTime <em>Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorTelemetryImpl extends MinimalEObjectImpl.Container implements ErrorTelemetry {
	/**
	 * The default value of the '{@link #getTelemetry() <em>Telemetry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelemetry()
	 * @generated
	 * @ordered
	 */
	protected static final String TELEMETRY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTelemetry() <em>Telemetry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelemetry()
	 * @generated
	 * @ordered
	 */
	protected String telemetry = TELEMETRY_EDEFAULT;

	/**
	 * The default value of the '{@link #getError() <em>Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getError()
	 * @generated
	 * @ordered
	 */
	protected static final String ERROR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getError() <em>Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getError()
	 * @generated
	 * @ordered
	 */
	protected String error = ERROR_EDEFAULT;

	/**
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final Date TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected Date time = TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorTelemetryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ma6icmodelPackage.Literals.ERROR_TELEMETRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTelemetry() {
		return telemetry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTelemetry(String newTelemetry) {
		String oldTelemetry = telemetry;
		telemetry = newTelemetry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.ERROR_TELEMETRY__TELEMETRY, oldTelemetry, telemetry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getError() {
		return error;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setError(String newError) {
		String oldError = error;
		error = newError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.ERROR_TELEMETRY__ERROR, oldError, error));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(Date newTime) {
		Date oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ma6icmodelPackage.ERROR_TELEMETRY__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Ma6icmodelPackage.ERROR_TELEMETRY__TELEMETRY:
				return getTelemetry();
			case Ma6icmodelPackage.ERROR_TELEMETRY__ERROR:
				return getError();
			case Ma6icmodelPackage.ERROR_TELEMETRY__TIME:
				return getTime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Ma6icmodelPackage.ERROR_TELEMETRY__TELEMETRY:
				setTelemetry((String)newValue);
				return;
			case Ma6icmodelPackage.ERROR_TELEMETRY__ERROR:
				setError((String)newValue);
				return;
			case Ma6icmodelPackage.ERROR_TELEMETRY__TIME:
				setTime((Date)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Ma6icmodelPackage.ERROR_TELEMETRY__TELEMETRY:
				setTelemetry(TELEMETRY_EDEFAULT);
				return;
			case Ma6icmodelPackage.ERROR_TELEMETRY__ERROR:
				setError(ERROR_EDEFAULT);
				return;
			case Ma6icmodelPackage.ERROR_TELEMETRY__TIME:
				setTime(TIME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Ma6icmodelPackage.ERROR_TELEMETRY__TELEMETRY:
				return TELEMETRY_EDEFAULT == null ? telemetry != null : !TELEMETRY_EDEFAULT.equals(telemetry);
			case Ma6icmodelPackage.ERROR_TELEMETRY__ERROR:
				return ERROR_EDEFAULT == null ? error != null : !ERROR_EDEFAULT.equals(error);
			case Ma6icmodelPackage.ERROR_TELEMETRY__TIME:
				return TIME_EDEFAULT == null ? time != null : !TIME_EDEFAULT.equals(time);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (telemetry: ");
		result.append(telemetry);
		result.append(", error: ");
		result.append(error);
		result.append(", time: ");
		result.append(time);
		result.append(')');
		return result.toString();
	}

} //ErrorTelemetryImpl
