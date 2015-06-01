Ext.define('TTT.model.Task', {
    extend: 'Ext.data.Model',
    
    fields: [
             { name: 'taskId', type: 'int', useNull:true },
             { name: 'taskName', type: 'string' },
             { name: 'projectId', type: 'int', useNull:true },
             { name: 'projectName', type: 'string', persist:false  },
             { name: 'companyId', type: 'int', useNull:true, persist:false  },
             { name: 'companyName', type: 'string', persist:false  }
    ]
});
