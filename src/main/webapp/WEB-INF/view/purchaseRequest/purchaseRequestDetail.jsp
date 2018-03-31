<%@ include file="/WEB-INF/view/masterPage/layout.jsp"%>
<section class="content">
<div class="row">
	<div class="col-xs-9">
		<h3>PURCHASE REQUEST DETAIL</h3>
		<hr style="border-color: black; border-top: 1px dashed;">
	</div>
	<div class="col-xs-3">
		<select id="action-pr" class="btn-primary form-control ">
			<option disabled selected>More</option>
			<option>Approve</option>
			<option>Reject</option>
			<option>Print</option>
			<option>Create PO</option>
		</select>
	</div>
</div>
<div class="row">
<div class="col-xs-4">
<table class="table table-hover">
	<tr>
		<th>PR Number</th>
		<td></td>
		<td>:</td>
		<td id="pr-number">${pr.prNo }</td>
	</tr>
	<tr>
		<th>Created By</th>
		<td></td>
		<td>:</td>
		<td id="created-by">${pr.createdBy }</td>
	</tr>
	<tr>
		<th>Target Waktu Item Ready</th>
		<td></td>
		<td> : </td>
		<td id="tgl-ready">${pr.readyTime }</td>
	</tr>
	<tr>
		<th>PR Status</th>
		<td></td>
		<td> : </td>
		<td id="status">${pr.status }</td>
	</tr>
</table>
</div>
</div>
<div class="form-group">
	<label for="input-note">Notes</label>
	<textarea class="form-control" id="input-note" rows="5"
		disabled="disabled">${pr.notes }</textarea>
</div>
<h5>
	<b>Status History</b>
</h5>
<hr style="border-color: black; border-top: 1px dashed;">
<div class="row">
	<div class="col-xs-5">
		<table id="data-history" class="table table-striped table-bordered table-hover">
			<c:forEach items="${pr.history }" var="his">
				<tr>
					<td>On</td>
					<td>${his.createdOn }</td>
					<td>-</td>
					<td>${pr.prNo }</td>
					<td>is</td>
					<td>${his.status }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

<h5>
	<b>Purchase Items</b>
</h5>
<hr style="border-color: black; border-top: 1px dashed;">
<table id="data-purchase-item"
	class="table table-striped table-bordered table-hover">
	<thead>
		<th>Item</th>
		<th>In Stock</th>
		<th>Request Qty.</th>
	</thead>
	<tbody id="list-item">
		<c:forEach items="${pr.detail }" var ="prd">
			<tr>
				<td>${prd.variant.item.name }-${prd.variant.name }</td>
				<td>null</td>
				<td>${prd.requestQty }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</section>
</body>
</html>