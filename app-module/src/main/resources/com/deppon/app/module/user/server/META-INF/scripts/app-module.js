Ext.define('Dpap.user.userDept.SelectConditionForm', {
	extend : 'Ext.form.Panel',
	id : 'Dpap_user_userDept_SelectConditionForm_ID',
	layout : 'column',
	height : 140,
	frame : true,
	title : user.i18n('dpap.app.user.queryCondition'),//'查询条件',
	defaults : {
		xtype : 'textfield',
		margin : '5 5 5 10'
	},
	initComponent : function(config) {
		var me = this, cfg = Ext.apply({}, config);
		me.buttons = [{
			text : user.i18n('dpap.app.user.reset'),//'重置',
			handler: function() {
				me.getForm().reset();
			}
		}, '->', {
			cls : 'yellow_button',
			text : user.i18n('dpap.app.user.query'),//'查询',
			// 查询按钮的响应事件：
			handler : function() {
				var grid = Ext.getCmp("Dpap_user_userDept_userDeptGrid_ID"),
					paggingBar = grid.getGridPaggingBar();
				grid.setVisible(true);
				paggingBar.moveFirst();
			}
		}];
		me.items = [{
			columnWidth : 0.333,
			name : 'empCode',
			fieldLabel : user.i18n('dpap.app.user.workNo')
		}, {
			columnWidth : 0.333,
			name : 'empName',
			fieldLabel : user.i18n('dpap.app.user.empName')//'职员姓名'
		}, {
			name : 'active',
			columnWidth : 0.333,
			fieldLabel : user.i18n('dpap.app.user.isActive'),//'是否启用',
			xtype : 'combo',
			store : Ext.create('Ext.data.Store', {
				fields : ['name', 'value'],
				data : [{
					'name' : user.i18n('dpap.app.user.active'),//'启用',
					'value' : 'Y'
				},{// 生效
					'name' : user.i18n('dpap.app.user.inActive'),//'未启用',
					'value' : 'N'
				}]// 失效
			}),
			queryMode : 'local',
			displayField : 'name',
			valueField : 'value'
		}];
		me.callParent([cfg]);
	}
});

// 查询的显示表格：
Ext.define('Dpap.user.userDept.UserDeptGrid', {
	extend : 'Ext.grid.Panel',
	id : 'Dpap_user_userDept_userDeptGrid_ID',
	cls : 'autoHeight',
	bodyCls : 'autoHeight',
	frame : true,
	hidden : true,
	title : user.i18n('dpap.app.user.userItem'),//'用户列表',
	// 设置表格不可排序
	sortableColumns : false,
	// 去掉排序的倒三角
	enableColumnHide : false,
	// 增加滚动条
	stripeRows : true, // 交替行效果
	collapsible : true,
	animCollapse : true,
	selType : "rowmodel", // 选择类型设置为：行选择
	userDeptDetailWindow: null,
	getUserDeptDetailWindow: function(){
		var me = this;
    	if (Ext.isEmpty(me.userDeptDetailWindow)) {
    		me.userDeptDetailWindow = Ext.create('Dpap.user.userDept.UserDeptDetailWindow');
    		user.userDeptAuthority.userDeptDetailWindow = me.userDeptDetailWindow;
    	}
    	return me.userDeptDetailWindow;
	},
	columns : [ {
		text : user.i18n('dpap.app.user.workNo'),//'工号',
		align : 'center',
		flex : 0.1,
		dataIndex : 'empCode',
		renderer : function(value) {
			if (value == null) {
				return '';
			}
			return value;
		}
	}, {
		text : user.i18n('dpap.app.user.empName'),//'员工姓名',
		align : 'center',
		flex : 0.7,
		dataIndex : 'username',
		renderer : function(value) {
			if (value == null) {
				return '';
			}
			return value;
		}
	}],
	gridPaggingBar: null,
	getGridPaggingBar: function(){
		var me = this;
		if(me.gridPaggingBar==null){
			me.gridPaggingBar = Ext.create('Deppon.StandardPaging', {
				store : me.store
			});
		}
		return me.gridPaggingBar;
	},
	constructor : function(config) {
		var me = this, cfg = Ext.apply({}, config);
		me.selModel = Ext.create('Ext.selection.RowModel');
		me.store = Ext.create('Dpap.user.UserStore', {
			constructor : function(config) {
				var me = this, cfg = Ext.apply({}, config);
				me.callParent([cfg]);
			},
			listeners : {
				beforeload : function(store, operation, eOpts) {
					var query_user_form = Ext.getCmp('Dpap_user_userDept_SelectConditionForm_ID');
					if (query_user_form != null) {
						var queryParams = query_user_form.getValues();
						Ext.apply(operation, {
							params : {
								// 设置请求参数
								'user.empEntity.empCode' : queryParams.empCode,
								'user.empEntity.empName' : queryParams.empName,
								'user.active' : queryParams.active
							}
						});
					}
				}
			}
		});
		me.bbar = me.getGridPaggingBar();
		me.callParent([cfg]);
	}
});

Ext.define('Dpap.user.UserModel', {
	extend : 'Ext.data.Model',
	fields : [{
		name : 'id'
	},{
		name :'empCode'
	}, {
		name : 'username'
	}]
});

/**
 * 定义用户数据加载器
 */
Ext.define('Dpap.user.UserStore', {
	extend : 'Ext.data.Store',
	pageSize : 15,
	model : 'Dpap.user.UserModel',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		actionMethods : 'POST',
		url : '../user/query.action',
		reader : {
			type : 'json',
			root : 'userList',
			totalProperty : 'totalCount'
		}
	}
});

Ext.onReady(function() {
	//1.禁止使用全局变量,可以使用module标签生成的模块名的object对象{}
	//	用法：模块名.自定义变量
	//2.对象都是用Ext.define定义的方式声明
	Ext.QuickTips.init();
	var selectConditionForm = Ext.create('Dpap.user.userDept.SelectConditionForm');
	var userDeptGrid = Ext.create('Dpap.user.userDept.UserDeptGrid');
	
	Ext.getCmp('T_user-userIndex').add(
		Ext.create('Ext.panel.Panel', {
			id : 'T_user-userIndex_content',
			cls : "panelContentNToolbar",
			bodyCls : 'panelContentNToolbar-body',
			getSelectConditionForm : function() {
				return selectConditionForm;
			} ,
			items : [selectConditionForm,userDeptGrid]
		})
	);
});