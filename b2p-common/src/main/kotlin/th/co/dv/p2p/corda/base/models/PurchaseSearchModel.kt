package th.co.dv.p2p.corda.base.models

import net.corda.core.serialization.CordaSerializable
import java.math.BigDecimal

@CordaSerializable
data class PurchaseSearchModel(
        val purchaseOrderExternalId: List<String>? = null,
        val exactPurchaseOrderExternalId: String? = null,
        val linearId: String? = null,
        val externalId: String? = null,
        val grInvoiceNumber: String? = null,
        val grNumber: String? = null,
        val grReferenceField1: String? = null,
        val grPostingDateFrom: String? = null,
        val grPostingDateTo: String? = null,
        val purchaseRequestNumber: String? = null,
        val vendorNumber: String? = null,
        val vendorName: String? = null,
        val companyCode: String? = null,
        val companyName: String? = null,
        val businessPlaceTaxNumber: String? = null,
        val exactBusinessPlaceTaxNumber: String? = null,
        val paymentTermCode: String? = null,
        val taxCode: String? = null,
        val businessPlace: String? = null,
        val statuses: List<String>? = null,
        val deleteFlag: String? = null,
        val vendorOfficerName: String? = null,
        val businessPlaceOfficerName: String? = null,
        val site: String? = null,
        val pageNumber : Int = 1,
        val pageSize : Int = 500,
        val sortField: String = "externalId",
        val sortOrder: Int = 1,
        val isItemAdvanceRemainingAmountGreaterThanZero: Boolean? = null,
        val itemCategory: String? = null,
        val itemDeliveryDateFrom: String? = null,
        val itemDeliveryDateTo: String? = null,
        val itemEffectiveDateFrom: String? = null,
        val itemEffectiveDateTo: String? = null,
        val returnPurchaseItems: Boolean = false,
        val purchaseUpdatedDateFrom: String? = null,
        val purchaseUpdatedDateTo: String? = null,
        val vendorTaxNumber: String? = null,
        val businessPlaceNumber: String? = null,
        val companyBranchCode: String? = null,
        val paymentTermDays: Long? = null,
        val paymentTermMonths: Int? = null,
        val purchaseOrderLinearId: String? = null,
        val purchasingGroup: String? = null,
        val referenceField1: String? = null,
        val referenceField2: String? = null,
        val referenceField3: String? = null,
        val referenceField4: String? = null,
        val referenceField5: String? = null,
        val entryDateFrom: String? = null,
        val entryDateTo: String? = null,
        val currency: String? = null,
        val linearIds: List<String>? = null,
        val businessPlaceTaxNumbers: List<String>? = null,
        val vendorTaxNumbers: List<String>? = null,
        val dashboardType: String? = null,
        val materialDescription: String? = null,
        val proposedRevisedDeliveryDateFrom: String? = null,
        val proposedRevisedDeliveryDateTo: String? = null,
        val expectedDeliveryDateFrom: String? = null,
        val expectedDeliveryDateTo: String? = null,
        val issuedDateFrom: String? = null,
        val issuedDateTo: String? = null,
        val documentEntryDateFrom: String? = null,
        val documentEntryDateTo: String? = null,
        val exactPurchaseItemExternalId: String? = null,
        val gtRemainingAmount: BigDecimal? = null,
        val ltRemainingAmount: BigDecimal? = null,
        val gtRemainingQuantity: BigDecimal? = null,
        val ltRemainingQuantity: BigDecimal? = null,
        val returnGoods: Boolean = false,
        val lifecycle: String? = null,
        val purchaseItemLinearIds: List<String>? = null,
        val purchaseOrderLinearIds: List<String>? = null,
        val headerDeleteFlag: String? = null,
        val dateFrom: String? = null,
        val dateTo: String? = null,
        val contractNumber: String? = null,
        val exactContractNumber: String? = null,
        val vendorOfficerEmailIsNull: Boolean? = null,
        val gtRemainingTotal: BigDecimal? = null
)