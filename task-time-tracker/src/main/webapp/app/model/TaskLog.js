Ext.define('TTT.model.TaskLog', {
    extend: 'Ext.data.Model',
    
    fields: [
             { name: 'idTaskLog', type: 'int', useNull:true },
             { name: 'taskDescription', type: 'string' },
             { name: 'taskLogDate', type: 'date', dateFormat:'Ymd' },
             { name: 'taskMinutes', type: 'int' },
             { name: 'hours', type: 'float', persist:false },
             { name: 'username', type: 'string' },
             { name: 'userFullName', type: 'string', persist:false },
             { name: 'idTask', type: 'int', useNull:true },
             { name: 'taskName', type: 'string', persist:false },
             { name: 'idProject', type: 'int', persist:false },
             { name: 'projectName', type: 'string', persist:false },
             { name: 'idCompany', type: 'int', persist:false },
             { name: 'companyName', type: 'string', persist:false }
    ]
});