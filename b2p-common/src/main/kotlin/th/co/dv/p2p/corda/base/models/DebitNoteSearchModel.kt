package th.co.dv.p2p.corda.base.models

/**
 * Search Model For Debit Note to enable the front end to query By:-
 * the fields available inside this state
 */
data class DebitNoteSearchModel (
        val debitNoteLinearId: List<String>? = null,
        val debitNoteExternalId: String? = null,
        val invoiceLinearId: List<String>? = null,
        val invoiceExternalId: String? = null,
        val requestLinearId: String? = null,
        val adjustmentType: List<String>? = null,
        val linearIds: List<String>? = null,
        val statuses: List<String>? = null,
        val debitNoteDateFrom: String? = null,
        val debitNoteDateTo: String? = null,
        val debitNoteDueDateFrom: String? = null,
        val debitNoteDueDateTo: String? = null,
        val debitNotePostingDateFrom: String? = null,
        val debitNotePostingDateTo: String? = null,
        val referenceField1: String? = null,
        val companyCode: String? = null,
        val companyName: String? = null,
        val vendorNumber: String? = null,
        val vendorName: String? = null,
        val isSellerStatus: Boolean = false,
        val returnDebitNoteItems: Boolean = true,
        val returnPurchaseItems: Boolean = false,
        val returnInvoiceItems: Boolean = false,
        val returnInvoice: Boolean = false,
        val companyTaxNumbers: List<String>? = null,
        val vendorTaxNumbers: List<String>? = null,
        val dueDateIsLocked: Boolean? = null,
        val customIndicator1: Boolean? = null,
        val ignoreZeroPayableAmount: Boolean? = null,
        val sortField: String = "externalId",
        val sortOrder: Int = 1,
        val pageNumber: Int = 1,
        val pageSize: Int = 500,
        val lifecycles: List<String>? = null,
        val postingStatus: List<String>? = null,
        val postingStatusNotIn: List<String>? = null,
        val paymentItemLinearIds: List<String>? = null,
        val debitNoteEntryDateFrom: String? = null,
        val debitNoteEntryDateTo: String? = null,
        val returnBuyerPostingDetail: Boolean = false,
        val buyerPostingDateFrom: String? = null,
        val buyerPostingDateTo: String? = null,
        val isRdSubmitted: Boolean? = null,
        val vatTriggerPoints: List<String>? = null,
        val companyTaxNumber: String? = null,
        val vendorTaxNumber: String? = null,
        val taxDocumentLinearIds : List<String>? = null,
        val taxDocumentNumber: String? = null,
        val taxDocumentLinearIdIsNull: Boolean? = null,
        val paymentDescription: String? = null,
        val isOnHold: Boolean? = null,
        val yearByDebitNoteDate: String? = null,
        val exactlyExternalNumber: String? = null
)