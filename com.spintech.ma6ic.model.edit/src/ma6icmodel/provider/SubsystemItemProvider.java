/**
 */
package ma6icmodel.provider;


import java.util.Collection;
import java.util.List;

import ma6icmodel.Ma6icmodelFactory;
import ma6icmodel.Ma6icmodelPackage;
import ma6icmodel.Subsystem;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link ma6icmodel.Subsystem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SubsystemItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubsystemItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addNoOfPacketsPropertyDescriptor(object);
			addAdapterPropertyDescriptor(object);
			addValidPropertyDescriptor(object);
			addNoOfReceivedPacketPropertyDescriptor(object);
			addTelemetrySizePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subsystem_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subsystem_name_feature", "_UI_Subsystem_type"),
				 Ma6icmodelPackage.Literals.SUBSYSTEM__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the No Of Packets feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNoOfPacketsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subsystem_noOfPackets_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subsystem_noOfPackets_feature", "_UI_Subsystem_type"),
				 Ma6icmodelPackage.Literals.SUBSYSTEM__NO_OF_PACKETS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Adapter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAdapterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subsystem_adapter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subsystem_adapter_feature", "_UI_Subsystem_type"),
				 Ma6icmodelPackage.Literals.SUBSYSTEM__ADAPTER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Valid feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValidPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subsystem_valid_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subsystem_valid_feature", "_UI_Subsystem_type"),
				 Ma6icmodelPackage.Literals.SUBSYSTEM__VALID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the No Of Received Packet feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNoOfReceivedPacketPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subsystem_noOfReceivedPacket_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subsystem_noOfReceivedPacket_feature", "_UI_Subsystem_type"),
				 Ma6icmodelPackage.Literals.SUBSYSTEM__NO_OF_RECEIVED_PACKET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Telemetry Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTelemetrySizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subsystem_telemetrySize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subsystem_telemetrySize_feature", "_UI_Subsystem_type"),
				 Ma6icmodelPackage.Literals.SUBSYSTEM__TELEMETRY_SIZE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(Ma6icmodelPackage.Literals.SUBSYSTEM__TELEMETRY);
			childrenFeatures.add(Ma6icmodelPackage.Literals.SUBSYSTEM__PACKET);
			childrenFeatures.add(Ma6icmodelPackage.Literals.SUBSYSTEM__COMMAND);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Subsystem.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Subsystem"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Subsystem)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Subsystem_type") :
			getString("_UI_Subsystem_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Subsystem.class)) {
			case Ma6icmodelPackage.SUBSYSTEM__NAME:
			case Ma6icmodelPackage.SUBSYSTEM__NO_OF_PACKETS:
			case Ma6icmodelPackage.SUBSYSTEM__VALID:
			case Ma6icmodelPackage.SUBSYSTEM__NO_OF_RECEIVED_PACKET:
			case Ma6icmodelPackage.SUBSYSTEM__TELEMETRY_SIZE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case Ma6icmodelPackage.SUBSYSTEM__TELEMETRY:
			case Ma6icmodelPackage.SUBSYSTEM__PACKET:
			case Ma6icmodelPackage.SUBSYSTEM__COMMAND:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(Ma6icmodelPackage.Literals.SUBSYSTEM__TELEMETRY,
				 Ma6icmodelFactory.eINSTANCE.createTelemetry()));

		newChildDescriptors.add
			(createChildParameter
				(Ma6icmodelPackage.Literals.SUBSYSTEM__PACKET,
				 Ma6icmodelFactory.eINSTANCE.createPacket()));

		newChildDescriptors.add
			(createChildParameter
				(Ma6icmodelPackage.Literals.SUBSYSTEM__COMMAND,
				 Ma6icmodelFactory.eINSTANCE.createCommand()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return Ma6icEditPlugin.INSTANCE;
	}

}
