Ext.define('TTT.model.Project', {
    extend: 'Ext.data.Model',
    
    fields: [
             { name: 'projectId', type: 'int', useNull:true },
             { name: 'projectName', type: 'string' },
             { name: 'companyId', type:'int', useNull:true },
             { name: 'companyName', type:'string', persist:false }
    ]
});