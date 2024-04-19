#!/bin/bash

if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <input_directory> <output_directory>"
    exit 1
fi

input_dir=$1
output_dir=$2

copy_files() {
    local source_dir=$1
    local target_dir=$2
    
    mkdir -p "$target_dir"
    
    cp -r "$source_dir"/* "$target_dir"
    
    for subdir in "$source_dir"/*/; do
        copy_files "$subdir" "$target_dir/$(basename "$subdir")"
    done
}

copy_files "$input_dir" "$output_dir"

