/*(function() {

$http({
	method: 'POST',
	url: '/accounting/diagnosis2/Diagnosislist',
	data:  $.param({
		diagnosis_number: $scope.diagnosis_number,
		diagnosis_name: $scope.diagnosis_name,
		dIagnosis_add: $scope.dIagnosis_add,
		sort: $scope.sort,
		diagnosis_type: $scope.diagnosis_type,
		use:$scope.use,
		remarks: $scope.remarks
	}),
	headers: {'Content-Type': 'application/json; charset=utf-8'}
})
.success(function(data, status, headers, config) {
	if( data ) {
		$scope.diagnosis_number = response.diagnosis_number;
	}
	else {
		console.log('실패');
		 통신한 URL에서 데이터가 넘어오지 않았을 때 처리 
	}
})
.error(function(data, status, headers, config) {
	 서버와의 연결이 정상적이지 않을 때 처리 
	console.log(status);
});
});*/


/*$(function() {
	var url = '/accounting/diagnosis2/Diagnosislist';
	$.ajax({
		url : url,
		dataType: 'xml',
		success: function(data) {
			var content = "";
			$.each(data, function(index, list) {
				content += '<tr class="maintable">';
				content += '<td class="center" style="width: 20px"></td>'
				content += '<td id="bigTitle" style="padding-left: 0px !important"><span style="font-weight: bolder; padding-left: 4px;">'+list.diagnosis_number+'</span>'+'</td>';
				
			})			
			
		}	
	});
	
	function name() {
		
	}
});*/

/*
(function () {
	
	var myApp = angular.module('myApp', []);
	
	myApp.controller('myController', function ($scope) {

		//트리 변환 메서드
		var treeModel = function (arrayList, rootId) {
			var rootNodes = [];
			var traverse = function (nodes, item, index) {
				if (nodes instanceof Array) {
					return nodes.some(function (node) {
						if (node.id === item.parentId) {
							node.children = node.children || [];
							return node.children.push(arrayList.splice(index, 1)[0]);
						}

						return traverse(node.children, item, index);
					});
				}
			};

			while (arrayList.length > 0) {
				arrayList.some(function (item, index) {
					if (item.parentId === rootId) {
						return rootNodes.push(arrayList.splice(index, 1)[0]);
					}

					return traverse(rootNodes, item, index);
				});
			}

			return rootNodes;
		};


		//트리로 변환할 배열
		var list =  [
			{ label : "subUser1", id : "role11", parentId : "role1" },
			{ label : "subUser2-1-1", id : "role1211", parentId : "role121" },
			{ label : "subUser2-1-2", id : "role1212", parentId : "role121" },
			{ label : "Admin", id : "role2", parentId : null },
			{ label : "subUser2", id : "role12", parentId : "role1" },
			{ label : "subUser2-1", id : "role121", parentId : "role12" },
			{ label : "Guest", id : "role3", parentId : null },
      { label : "User", id : "role1", parentId : null }
		];
		$scope.list = JSON.stringify(list, null, '   ');    
    
		//트리 모델로 변환
		var tree = treeModel(list, null);		
		$scope.tree = JSON.stringify(tree, null, '   ');
	});
	
})();*/