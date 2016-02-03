
// Fetch all students whose notes in a specific course were greater than 4.
print("\nFetch all students whose notes in a specific course (in this case, Math) were greater than 4.")
print("\nResult for query: db.students.find({ courses: { $elemMatch: {'name': 'Math', 'final': {$gt: 4}}}})\n")
db.students.find({ courses: { $elemMatch: {'name': 'Math', 'final': {$gt: 4}}}})

// Fetch all courses ordered by name for a given teacher.
print("\nFetch all courses ordered by name for a given teacher (id=2)")
print("\nResult for query: db.courses.find({ 'teacher.teacher_id':2}).sort( { name: 1})\n")
db.courses.find({ 'teacher.teacher_id':2}).sort( { name: 1})
