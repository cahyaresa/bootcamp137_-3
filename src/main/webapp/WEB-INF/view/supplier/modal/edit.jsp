<!-- begin form save -->
	<div class="modal fade" id="modal-edit" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					
					<button type="button" class="close modalcancel" data-dismiss="modal">&times;</button>
					<h4 id="judul-modal">Edit Supplier</h4>
				</div>
				<div class="modal-body">
					<form id="formdepartemen" data-parsley-validate method="post">
						<table>
							<tr>
								<td>Supplier Name</td>
								<td>:</td>
								<td><input type="text" name="edit-name" id="edit-name" data-parsley-required="true" /></td>
							</tr>
							
							<tr>
								<td>Address</td>
								<td>:</td>
								<td><input type="text" name="edit-address" id="edit-address" data-parsley-required="true" /></td>
							</tr>
							
							<tr>
								<td>Phone</td>
								<td>:</td>
								<td><input type="text" name="edit-phone" id="edit-phone" data-parsley-required="true" /></td>
							</tr>
							
							<tr>
								<td>Email</td>
								<td>:</td>
								<td><input type="text" name="edit-email" id="edit-email" data-parsley-required="true" placeholder="example: alfa@gmail.com" /></td>
							</tr>
							
							<tr>
								<td>Postal Code</td>
								<td>:</td>
								<td><input type="text" name="supplier-postal" id="edit-postal" data-parsley-required="true" placeholder="max six characters" /></td>
							</tr>
							
							<tr>
								<td><input type="hidden" name="id" id="edit-id"></td>
							</tr>
						</table>
						
						<table>
						<thead>
							<tr>
								<td class="text-center">Province</td>
								<td class="text-center">Region</td>
								<td class="text-center">District</td>
							</tr>
						</thead>
						
						<tbody>
						<tr>
						
						<td>
						<select name="area" required="required" id="prov-edit">
    					<option disabled selected value=""> --- Select A Province --- </option>
    					<c:forEach var="prov" items="${provinces }">
    						<option value="${prov.id }">${prov.name }</option>
    					</c:forEach>
						</select>
						</td>
						
						<td>
						<select name="area" required="required" id="reg-edit">
    						<option disabled selected value=""> --- Select A Region --- </option>
						</select>
						</td>
						
						<td>
						<select name="area" required="required" id="dist-edit">
    						<option disabled selected value=""> --- Select A District --- </option>
						</select>
						</td>
						
						</tr>
						</tbody>
						</table>
						
						
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" id="tbl-delete">X</button>
					<button type="reset" class="btn btn-warning" id="tbl-cancel">Cancel</button>
					<button type="button" class="btn btn-info" id="tbl-edit">Save</button>
				</div>
				
				</form>
			</div>

		</div>
	</div>
<!-- end form save -->