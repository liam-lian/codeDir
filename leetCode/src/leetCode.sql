-- delete-duplicate-emails
SELECT min(id),email FROM Person group by email;

