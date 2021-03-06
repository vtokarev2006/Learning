Ext.define('TTT.model.User', {
    extend: 'Ext.data.Model',
    
    fields: [
             { name: 'username', type: 'string' },
             { name: 'firstName', type: 'string' },
             { name: 'lastName', type: 'string' },
             { name: 'fullName', type: 'string', persist:false },
             { name: 'email', type: 'string' },
             { name: 'password', type: 'string' },
             { name: 'adminRole', type: 'string' }
    ],
    idProperty: 'username'
});
