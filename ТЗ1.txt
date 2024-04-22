#!/bin/bash

if [ "$#" -ne 2 ]; then
    echo "Использование: $0 <входная_директория> <выходная_директория>"
    exit 1
fi

input_dir=$1
output_dir=$2

copy_files() {
    local source_dir=$1
    local target_dir=$2
    mkdir -p "$target_dir"

    find "$source_dir" -type f | while read file; do
        local base_name=$(basename "$file")
        local copy_path="$target_dir/$base_name"
        local counter=1
        while [ -f "$copy_path" ]; do
            copy_path="${target_dir}/${base_name%.*}_$counter.${base_name##*.}"
            ((counter++))
        done

        cp "$file" "$copy_path"
    done

    for subdir in "$source_dir"/*/; do
        if [ -d "$subdir" ]; then
            copy_files "$subdir" "$target_dir"
        fi
    done
}

copy_files "$input_dir" "$output_dir"


