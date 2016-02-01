
db.students.drop()
db.courses.drop()

course1 = ObjectId()
course2 = ObjectId()
course3 = ObjectId()

db.courses.insert([
	{	name:"Math",
		_id: course1,
		teacher: {
			teacher_id: 1,
			firstame: "John",
			lastname: "Doe",
			birthdate:"1980-09-14" },
		hoursbyweek:2,
		schedule: [{
			dayofweek: 'Wednesday',
			starttime: '10:30',
			endtime: '11:30'},
			{
			dayofweek: 'Monday',
			starttime: '08:00',
			endtime: '09:00'
			}
		]
	},
	{	name:"Music",
		_id: course2,
		teacher: {
			teacher_id: 2,
			firstame: "Jack",
			lastname: "Black",
			birthdate:"1977-06-01" },
		hoursbyweek:2,
		schedule: [
			{	dayofweek: 'Thursday',
				starttime: '09:30',
				endtime: '10:30' },
			{	dayofweek: 'Friday',
				starttime: '08:30',
				endtime: '10:30' }
		]
	},
	{	name:"Chemistry",
		_id: course3,
		teacher: {
			teacher_id: 2,
			firstame: "Jack",
			lastname: "Black",
			birthdate:"1986-05-15" },
		hoursbyweek:1,
		schedule: [ {
			dayofweek: 'Tuesday',
			starttime: '08:00',
			endtime: '09:00' }]
	}
])

db.students.insert([
	{	student_id: 1,
		firstname: 'First Name 1',
		lastname: 'Last Name 1',
		regnum: 105,
		birthdate: '1999-02-20',
		courses: [
			{ course_id: course1,
				name: 'Math',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6}
		]
	},
	{	student_id: 2,
		firstname: 'First Name 2',
		lastname: 'Last Name 2',
		regnum: 106,
		birthdate: '1999-03-29',
		courses: [
			{ course_id: course1,
				name: 'Math',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6},
			{ course_id: course3,
				name: 'Chemistry',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 3}
		]
	},
	{	student_id: 3,
		firstname: 'First Name 3',
		lastname: 'Last Name 3',
		regnum: 107,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course1,
				name: 'Math',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 3}
		]
	},
	{	student_id: 4,
		firstname: 'First Name 4',
		lastname: 'Last Name 4',
		regnum: 108,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course1,
				name: 'Math',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6},
			{ course_id: course3,
				name: 'Chemistry',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6}
		]
	},
	{	student_id: 5,
	 	firstname: 'First Name 5',
		lastname: 'Last Name 6',
		regnum: 109,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course1,
				name: 'Math',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6}
		]
	},
	{	student_id: 6,
	 	firstname: 'First Name 6',
		lastname: 'Last Name 6',
		regnum: 110,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course1,
				name: 'Math',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final:9	},
			{ course_id: course3,
				name: 'Chemistry',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 }
		]
	},
	{	student_id: 7,
	 firstname: 'First Name 7',
		lastname: 'Last Name 7',
		regnum: 111,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course1,
				name: 'Math',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 }
		]
	},
	{	student_id: 8,
	 firstname: 'First Name 8',
		lastname: 'Last Name 8',
		regnum: 112,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course1,
				name: 'Math',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 2 },
			{ course_id: course3,
				name: 'Chemistry',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 }
		]
	},
	{	student_id: 9,
	 firstname: 'First Name 9',
		lastname: 'Last Name 9',
		regnum: 113,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course1,
				name: 'Math',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 }
		]
	},
	{	student_id: 10,
	  firstname: 'First Name 10',
		lastname: 'Last Name 10',
		regnum: 114,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course1,
				name: 'Math',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 2 },
			{ course_id: course3,
				name: 'Chemistry',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 8 }
		]
	},
	{	student_id: 11,
	  firstname: 'First Name 11',
		lastname: 'Last Name 11',
		regnum: 115,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course2,
				name: 'Music',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 }
		]
	},
	{	student_id: 12,
	  firstname: 'First Name 12',
		lastname: 'Last Name 12',
		regnum: 116,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course2,
				name: 'Music',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 },
			{ course_id: course3,
				name: 'Chemistry',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 }
		]
	},
	{	student_id: 13,
	  firstname: 'First Name 13',
		lastname: 'Last Name 13',
		regnum: 117,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course2,
				name: 'Music',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 }
		]
	},
	{	student_id: 14,
	  firstname: 'First Name 14',
		lastname: 'Last Name 14',
		regnum: 118,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course2,
				name: 'Music',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 },
			{ course_id: course3,
				name: 'Chemistry',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 }
		]
	},
	{	student_id: 15,
	  firstname: 'First Name 15',
		lastname: 'Last Name 15',
		regnum: 119,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course2,
				name: 'Music',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 }
		]
	},
	{	student_id: 16,
	  firstname: 'First Name 16',
		lastname: 'Last Name 16',
		regnum: 120,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course2,
				name: 'Music',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 },
			{ course_id: course3,
				name: 'Chemistry',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 }
		]
	},
	{	student_id: 17,
	  firstname: 'First Name 17',
		lastname: 'Last Name 17',
		regnum: 121,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course2,
				name: 'Music',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 }
		]
	},
	{	student_id: 18,
	  firstname: 'First Name 18',
		lastname: 'Last Name 18',
		regnum: 122,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course2,
				name: 'Music',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 },
			{ course_id: course3,
				name: 'Chemistry',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 }
		]
	},
	{	student_id: 19,
	  firstname: 'First Name 19',
		lastname: 'Last Name 19',
		regnum: 123,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course2,
				name: 'Music',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 }
		]
	},
	{	student_id: 20,
	  firstname: 'First Name 20',
		lastname: 'Last Name 20',
		regnum: 124,
		birthdate: '1999-04-28',
		courses: [
			{ course_id: course2,
				name: 'Music',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 },
			{ course_id: course3,
				name: 'Chemistry',
				parcial1: 4,
				parcial2: 2,
				parcial3: 5,
				final: 6 }
		]
	}
])
