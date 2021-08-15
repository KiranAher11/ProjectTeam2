export const NAV_ITEMS_LIST = [
    {
        permitTo: ['nurse','physician'], icon: 'inbox', navItem: 'Inbox', route: 'inbox/sharedinbox'
    },
    {
        permitTo: ['physician'], icon: 'notes', navItem: 'Visit Form', route: 'visit/visit_form'
    },
    {
        permitTo: ['nurse'], icon: 'notes', navItem: 'Vital Signs', route: 'visit/vital_form'
    },
    {
        permitTo: ['admin'], icon: 'notes', navItem: 'User Registration', route: 'admin/userRegistration'
    },
    {
        permitTo: ['physician'], icon: 'notes', navItem: 'Appointment Details', route: 'schedule/appointmentDetails'
    },
    {
        permitTo: ['physician'], icon: 'calendar_today', navItem: 'Calendar', route: 'schedule/calendarapi'
    },
    {
        permitTo: ['patient'], icon: 'notes', navItem: 'Book Appointment', route: 'visit/appointment_form'
    },
    {
        permitTo: ['admin'], icon: 'people', navItem: 'Patients', route: 'admin/userList'
    },
    {
        permitTo: ['patient'], icon: 'create', navItem: 'Demographics Details', route: 'usermanagement/patient_details'
    },
    {
        permitTo: ['admin'], icon: 'create', navItem: 'Hospital user List', route: 'admin/hospitalUserList'
    }
];
