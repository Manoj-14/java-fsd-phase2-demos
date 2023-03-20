create trigger setmodifier before update on person
for each row begin
	set new.created = now();
end;

drop trigger setmodifier;